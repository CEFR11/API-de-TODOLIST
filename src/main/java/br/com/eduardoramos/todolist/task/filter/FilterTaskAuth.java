package br.com.eduardoramos.todolist.task.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter; //servlet, base pra todo framework web no Java
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component // toda classe que queira que o spring gerencie, precisa colocar @Component , @RestControlle
public class FilterTaskAuth implements Filter{

    @Override

    //validar se o usuario esta autenticado
    // Para que possa cadastrar a tarefa dentro da aplicação
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

      //Executar alguma ação

      System.out.println("Chegou no filtro");
      chain.doFilter(request, response);

    }
    
}