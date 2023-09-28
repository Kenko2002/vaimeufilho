package api.todo.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.todo.apllication.AppProduto;
import api.todo.model.Produto;

@RestController
@RequestMapping("/crud_produto")
public class ProdutoController {
	
	@Autowired AppProduto appproduto;
	
	@GetMapping("getbyid/{id}")
	public Produto getById(@PathVariable long id) {
		return appproduto.findById(id);
	}
	
	@GetMapping("/getall")
	public ArrayList<Produto> getAll(){
		return appproduto.getAll();
	}
	
	@PostMapping("/")
	public Produto createProduto(@RequestBody Produto produto) {
		return appproduto.createProduto(produto);
	}
	
	@PutMapping("/updatebyid/{id}")
	public Produto updatebyid(@PathVariable Long id, @RequestBody Produto produto) {
		return appproduto.updatebyid(id,produto);
	}
	
	@DeleteMapping("/{id}/delete_produto")
	public void delete(@PathVariable Long id) {
		appproduto.delete(id);
	}
	
	
	
}
