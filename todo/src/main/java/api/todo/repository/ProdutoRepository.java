package api.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.todo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
