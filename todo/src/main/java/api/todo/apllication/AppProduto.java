package api.todo.apllication;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.todo.model.Produto;
import api.todo.repository.ProdutoRepository;

@Component
public class AppProduto {

	@Autowired
	private ProdutoRepository repository;
	//camada de logica de negocio
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private Long lastId=Long.parseLong("0");
	
	public Produto findById(Long id){
		return repository.findById(id).orElse(null);
	}
	
	public Produto updatebyid(Long id, Produto produtoNovo) {
		Produto produto = repository.findById(id).orElse(null);
		produto.setNome(produtoNovo.getNome());
		produto.setPreco(produtoNovo.getPreco());
		repository.save(produto);
		return produto;
	}
	
	public ArrayList<Produto> getAll(){
		return (ArrayList<Produto>) repository.findAll();
	}
	
	public Produto createProduto(Produto produto) {
		return repository.save(produto);
	}
	
	public void delete(Long id) {
		//this.produtos.removeIf(produto -> produto.getId().equals(id));
		repository.deleteById(id);
	}
	
}
