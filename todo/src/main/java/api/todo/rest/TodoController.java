package api.todo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import api.todo.model.Todo;
import api.todo.repository.TodoRepository;

//a funcao do controller é controlar as rota e as views da aplicação (url)

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired
	private TodoRepository repository;
	
	@PostMapping
	public Todo save(@RequestBody Todo todo) {
		return repository.save(todo);
	}
	
	// busca o todo pelo URL.
	// url/api/todos/1  
	@GetMapping("{id}")
	public Todo getById(@PathVariable long id) {
		return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}


