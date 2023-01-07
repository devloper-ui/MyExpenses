//package com.kunal.springboot.web.springbootfirstwebapplication.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.kunal.springboot.web.springbootfirstwebapplication.model.Todo;
//import com.kunal.springboot.web.springbootfirstwebapplication.service.TodoRepository;
//import com.kunal.springboot.web.springbootfirstwebapplication.service.TodoService;
//
//@Controller
//public class TodoController {
//	
////	@Autowired
////	TodoService toDoService;
//	
//	@Autowired
//	TodoRepository repository;
//	
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(
//				dateFormat, false));
//	}
//
//	@RequestMapping(value="/list-todos", method = RequestMethod.GET)  //this is url login
//	public String showTodos(ModelMap model){
//		String name = getLoggedInUserName(model);
//		//model.put("todos", toDoService.retrieveTodos(name));
//		model.put("todos", repository.findByUser(name));
//		return "list-todos";  //call to jsp file
//	}
//
//	private String getLoggedInUserName(ModelMap model) {
//		Object principal = SecurityContextHolder.getContext()
//				.getAuthentication().getPrincipal();
//		if(principal instanceof UserDetails){
//			return ((UserDetails) principal).getUsername();
//		}
//		return principal.toString();
//
//	}
//
//	@RequestMapping(value="/add-todo", method = RequestMethod.GET)  //this is url login
//	public String showAddTodoPage(ModelMap model){
//		model.addAttribute("todo",new Todo(0, getLoggedInUserName(model),"Add desc here",new Date(),false));
//		return "todo";  //call to jsp file
//	}
//	
//	@RequestMapping(value="/add-todo", method = RequestMethod.POST)  //this is url login
//	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){
//		if(result.hasErrors()){
//			return "todo";
//		}
//		todo.setUser(getLoggedInUserName(model));
//		repository.save(todo);
//		//toDoService.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false);
//		return "redirect:/list-todos";  //call to jsp file
//	}
//
//	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)  //this is url login
//	public String deleteTodo(@RequestParam int id){
//		repository.deleteById(id);
//		//toDoService.deleteTodo(id);
//		return "redirect:/list-todos";  //call to jsp file
//	}
//	
//	@RequestMapping(value="/update-todo", method = RequestMethod.GET)  //this is url login
//	public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
//		Todo todo = repository.findById(id).get();
//		//Todo todo = toDoService.retrieveTodo(id);
//		model.put("todo", todo);
//		return "todo";  //call to jsp file
//	}
//	
//	@RequestMapping(value="/update-todo", method = RequestMethod.POST)  //this is url login
//	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
//		if(result.hasErrors()){
//			return "todo";
//		}
//		todo.setUser(getLoggedInUserName(model));
//		repository.save(todo);
//		//toDoService.updateTodo(todo);
//		return "redirect:/list-todos";  //call to jsp file
//	}	
//
//}
