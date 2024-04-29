package com.sai.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();

	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount,"Sai","Full Stack",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"Sai","DevOps",
				LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount,"Sai","AWS",
				LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	public void addTodo(String username,String description,LocalDate date) {
		todos.add(new Todo(++todosCount,username,description,
				date,false));
	}
	public void deleteById(int id) {
		
		Predicate<? super Todo> predicate=todo->(todo.getId()==id);
		todos.removeIf(predicate);
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate=todo->(todo.getId()==id);
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

}
