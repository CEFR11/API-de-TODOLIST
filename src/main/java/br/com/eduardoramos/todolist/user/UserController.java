package br.com.eduardoramos.todolist.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {
    
 
    @Autowired
    private IUserReposity userReposity;

@PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel){
        var user = this.userReposity.findByUsername(userModel.getUsername());
        
        if(user != null){
            //Utilizandoo ResponseEntity para retornar repostas HTTP apropriadas
            // Mensagem de erro
             //Usei o BAD__REQUEST para indicar que o usuário ja existe.
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário ja existe");
        }

        var passwordHashred = BCrypt.withDefaults() //Criptografando a senha do usuario
        .hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);



        var userCreated = this.userReposity.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated); 
        // Utilizei HTTPStatus para definir o status code , e HttpStatus.CREATED para indicar que o usuario foi criado com sucesso
        // .body para retorna o UserCreated
    }



}
