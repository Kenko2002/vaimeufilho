package api.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.todo.model.Todo;

//<Todo,Long> significa o tipo da entidade que está sendo administrada e o tipo do ID dela.
public interface TodoRepository extends JpaRepository<Todo,Long> {

}
