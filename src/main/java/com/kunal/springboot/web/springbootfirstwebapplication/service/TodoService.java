//package com.kunal.springboot.web.springbootfirstwebapplication.service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.kunal.springboot.web.springbootfirstwebapplication.model.Todo;;
//
//
//@Service
//public class TodoService {
//    private static List<Todo> todos = new ArrayList<Todo>();
//    private static int todoCount = 5;
//
//    static {
//        todos.add(new Todo(1, "Kunal", "Learn Spring MVC", new Date(),
//                false));
//        todos.add(new Todo(2, "Kunal", "Learn Spring boot", new Date(),
//                false));
//        todos.add(new Todo(3, "Kunal", "Learn React", new Date(),
//                false));
//        todos.add(new Todo(4, "in28Minutes", "Learn Struts", new Date(), false));
//        todos.add(new Todo(5, "in28Minutes", "Learn Hibernate", new Date(),
//                false));
//    }
//
//    public List<Todo> retrieveTodos(String user) {
//        List<Todo> filteredTodos = new ArrayList<Todo>();
//        for (Todo todo : todos) {
//            if (todo.getUser().equals(user)) {
//                filteredTodos.add(todo);
//            }
//        }
//        return filteredTodos;
//    }
//
//    public Todo retrieveTodo(int id) {
//        for (Todo todo : todos) {
//            if (todo.getId()==id) {
//                return todo;
//            }
//        }
//        return null;
//    }
//
//    public void addTodo(String name, String desc, Date targetDate,
//            boolean isDone) {
//        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
//    }
//
//    public void updateTodo(Todo todo){
//    	todos.remove(todo);
//    	todos.add(todo);
//    }
//    
//    public void deleteTodo(int id) {
//        Iterator<Todo> iterator = todos.iterator();
//        while (iterator.hasNext()) {
//            Todo todo = iterator.next();
//            if (todo.getId() == id) {
//                iterator.remove();
//            }
//        }
//    }
//}