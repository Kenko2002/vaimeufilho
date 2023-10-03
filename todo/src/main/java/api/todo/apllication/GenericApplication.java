package api.todo.apllication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenericApplication<T, ID> {
    @Autowired
    private JpaRepository<T, ID> repository;

    public List<T> listarTodos() {
        return repository.findAll();
    }

    public T updatebyid(ID id, T NovoEntidade) {
		T VelhaEntidade = repository.findById(id).orElse(null);
		VelhaEntidade=NovoEntidade;
		repository.save(VelhaEntidade);
		return VelhaEntidade;
	}
    
    public Optional<T> buscarPorId(ID id) {
        return repository.findById(id);
    }

    public T salvar(T entidade) {
        return repository.save(entidade);
    }

    public void excluir(ID id) {
        repository.deleteById(id);
    }
}
