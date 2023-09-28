package api.todo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloWorld")
public class HelloController {
	
	@GetMapping("/")
	public String helloWorld() {
		return "HelloWorld!";
	}
	
	//gambiarra
	@GetMapping("{num}")
	public String MostrarNum(@PathVariable String num) {
		return ("O Número inserido foi: "+num);
	}
	
	//ideal para formulários
	@GetMapping("/mostrarnome")
	public String Mostrarnome(@RequestParam String nome) {
		return ("O Nome inserido foi: "+nome);
	}
	
	
}

