package com.livraria.exerc.cio.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.exerc.cio.livraria.entity.Livraria;
import com.livraria.exerc.cio.livraria.repository.LivrariaRepository;

@Service
public class LivrariaServiceImpl implements LivrariaService {
	
	@Autowired
	private LivrariaRepository livrariaRepository;
	
	@Override
	public List<Livraria> findAll() {
		
		return livrariaRepository.findAll();
	}

	@Override
	public Livraria findById(int theId) {
		Optional<Livraria> result = livrariaRepository.findById(theId);
		
		Livraria theLivraria = null;
		
		if(result.isPresent()) {
			theLivraria = result.get();
		}
		
		return theLivraria;
	}

	@Override
	public void save(Livraria livro) {
		livrariaRepository.save(livro);

	}

	@Override
	public void delete(int theId) {
		livrariaRepository.deleteById(theId);

	}

}
