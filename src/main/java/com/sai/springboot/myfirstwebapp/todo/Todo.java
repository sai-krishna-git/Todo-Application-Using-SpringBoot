package com.sai.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

public class Todo {
	private int id;
	private String username;
	@Size(min=10,message="Enter Atleast 10 Characters")
	private String description;
	@FutureOrPresent(message="Target Date can't be past")
	private LocalDate targetDate;
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	private boolean done;
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

}
