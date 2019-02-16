package com.livraria.exerc.cio.livraria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.exerc.cio.livraria.entity.Livraria;
import com.livraria.exerc.cio.livraria.service.LivrariaService;

@RestController
@RequestMapping("/api")
public class LivrariaResource {
	
	@Autowired
	private LivrariaService livrariaService;
	
	@GetMapping(value="/livros")
	public List<Livraria>findAll(){
		
		return livrariaService.findAll();
	}
	
	@GetMapping("/livros/{livroId}")
	public Livraria getLivroById(@PathVariable int livroId) {
		Livraria livro = livrariaService.findById(livroId);
		
		if(livro == null) {
			throw new RuntimeException("Id do Livro não existente: " + livroId);
		}
		
		return livro;
	}
	
	@PostMapping("/livros")
	public Livraria addLivro(@RequestBody Livraria theLivro) {
		
		theLivro.setId(0);
		
		livrariaService.save(theLivro);
		
		return theLivro;
	}
	
	@PutMapping("/livros/{livroId}")
	public Livraria updateLivro(@RequestBody Livraria theLivro, @PathVariable int livroId) {
		
		Livraria livro = livrariaService.findById(livroId);
		
		if(livro == null) {
			throw new RuntimeException("Id de livro não existente: " + livroId);
		}
		
		theLivro.setId(livroId);
		livrariaService.save(theLivro);
		
		return theLivro;
	}
	
	@DeleteMapping("/livros/{livroId}")
	public String deleteLivro(@PathVariable int livroId) {
		
		Livraria livro = livrariaService.findById(livroId);
		
		if(livro == null) {
			throw new RuntimeException("Id não existente: " + livroId);
		}
		
		livrariaService.delete(livroId);
		
		return "Cadastro do Livro deletado: " + livroId;
		
		
	}
	

}
