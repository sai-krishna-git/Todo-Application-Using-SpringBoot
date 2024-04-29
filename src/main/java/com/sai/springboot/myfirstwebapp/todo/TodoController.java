package com.sai.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("Sai");
		model.addAttribute("todos",todos);
		return "listTodos";
	}
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String ShowNewTodoPage(ModelMap model) {
		Todo todo = new Todo(0,"default","",LocalDate.now().plusYears(1),false);
		model.addAttribute("todo", todo);
		return "todo";
	}
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors())
			return "todo";
		todoService.addTodo((String)model.get("name"),todo.getDescription(),todo.getTargetDate());
		return "redirect:list-todos";
	}
	@RequestMapping(value="delete-todo",method = RequestMethod.GET)
	public String deleteNewTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value="update-todo")
	public String showUpdateTodopage(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
//	Another way of doing
//	@RequestMapping(value="update-todo",method = RequestMethod.GET)
//	public String showUpdateTodopage(@RequestParam int id,ModelMap model) {
//		Todo todo = todoService.findById(id);
//		model.put("todo", todo);
//		return "updateTodo";
//	}
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String UpdateTodo(@RequestParam int id,ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors())
			return "updateTodo";
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	

}
