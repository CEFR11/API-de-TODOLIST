package br.com.eduardoramos.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/tasks") 

//Tudo que for feito nesse controller, sera mapeado para /tasks

public class TaskController {


    @Autowired //Injeção de dependencia para instanciar o repositorio 
    private ITaskRepository taskRepository; 


  // RequesteBody, para receber o corpo da requisição
   //TaskModel, para receber o modelo da tarefa
   //void, para nao receber nada

   @PostMapping("/")
public TaskModel create(@RequestBody TaskModel taskModel){
   var task =  this.taskRepository.save(taskModel);
   return task;

    
}
    
}
