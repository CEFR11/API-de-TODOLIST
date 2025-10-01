package br.com.eduardoramos.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserReposity extends JpaRepository<UserModel,UUID>{
   UserModel findByUsername(String username);
}
