package api.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.todo.apllication.GenericApplication;
import api.todo.model.Pessoa;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private GenericApplication<Pessoa, Long> pessoaApp;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaApp.listarTodos();
    }

    @GetMapping("/{id}")
    public Pessoa buscarPessoaPorId(@PathVariable Long id) {
        return pessoaApp.buscarPorId(id).orElse(null);
    }

    @PostMapping("/criarpessoa")
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaApp.salvar(pessoa);
    }

    @DeleteMapping("/{id}")
    public void excluirPessoa(@PathVariable Long id) {
        pessoaApp.excluir(id);
    }
}