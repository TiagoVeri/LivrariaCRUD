package com.livraria.exerc.cio.livraria.service;

import java.util.List;

import com.livraria.exerc.cio.livraria.entity.Livraria;

public interface LivrariaService {
	
	public List<Livraria> findAll();
	
	public Livraria findById(int theId);
	
	public void save(Livraria livro);
	
	public void delete(int theId);
	
	
}
