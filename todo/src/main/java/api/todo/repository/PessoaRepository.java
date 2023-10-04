package api.todo.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.todo.model.Pessoa;

@Primary
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    // Métodos personalizados do repositório, se necessário
}