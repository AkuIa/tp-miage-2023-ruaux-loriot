package com.acme.todolist.adapters.rest_api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.port.out.UpdateTodoItem;
import com.acme.todolist.domain.TodoItem;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQuery;
	private AddTodoItem setTodoItemsQuery;
	//private  UpdateTodoItem updateTodoItem;
	// A compléter
	
	
	@Inject
	//A compléter
	public TodoListController(GetTodoItems getTodoItemsQuery, AddTodoItem setTodoItemsQuery, UpdateTodoItem updateTodoItem) {
		this.getTodoItemsQuery = getTodoItemsQuery;
		this.setTodoItemsQuery = setTodoItemsQuery;
		//this.updateTodoItem = updateTodoItem;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	// Endpoint de type POST vers "/todos"
	// A compléter
	@PostMapping("/todos")
	public void ajouterItem(@RequestBody TodoItem item) {
		// A compléter
		//this.updateTodoItem.storeNewTodoItem(item);
		this.setTodoItemsQuery.addTodoItem(item);
	}
	
	
}
