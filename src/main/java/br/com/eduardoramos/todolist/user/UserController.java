package br.com.eduardoramos.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
 
    @Autowired
    private IUserReposity userReposity;

@PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel){
        var user = this.userReposity.findByUsername(userModel.getUsername());
        
        if(user != null){
            System.out.println("Usuário já existe");
            return null;
        }

        var userCreated = this.userReposity.save(userModel);
        return userCreated;
    }


}
