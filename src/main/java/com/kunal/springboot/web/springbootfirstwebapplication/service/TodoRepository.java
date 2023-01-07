//package com.kunal.springboot.web.springbootfirstwebapplication.service;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.kunal.springboot.web.springbootfirstwebapplication.model.Todo;
//
//public interface TodoRepository extends JpaRepository<Todo, Integer> {
////Jpa provides all methods like crud but it need id as a parameter so we are 
////creating a method which csn retrieve by name 
//	List<Todo> findByUser(String user);    //why find by user ? because user in column(variable) 
//										   //name in todo class so spring will automaticlly 
//											//provide method implementation
//}
