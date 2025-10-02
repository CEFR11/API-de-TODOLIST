package br.com.eduardoramos.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


 @Data //Gerar os getters e setters automaticamente
 @Entity(name = "tb_tasks") //nomeando entidade
 public class TaskModel  {
    

    @Id
    @GeneratedValue(generator = "UUID") //gerar UUID automatico
    private UUID id; //Identificador unico universal
    private String description; // Descrição da tarefa

    @Column(length = 50) // limitar o tamanho do titulo por 50 carecteres
    private String title; //Titulo da tarefa
    private LocalDateTime startAt; //Data de início
    private LocalDateTime endAt; //Data de término
    private String priority; //Baixa,Media,Alta
    @CreationTimestamp //anotação para definir que a data de criação sera gerada automaticamente
    private LocalDateTime createdAt; //data de criação

    
    private String idUser;



}
