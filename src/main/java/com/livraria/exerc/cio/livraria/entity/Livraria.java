package com.livraria.exerc.cio.livraria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class Livraria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="alugado")
	private boolean alugado;

	public Livraria() {
		
	}
	
	public Livraria(int id, String nome, String autor, boolean alugado) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.alugado = alugado;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

	@Override
	public String toString() {
		return "Livraria [id=" + id + ", nome=" + nome + ", autor=" + autor + ", alugado=" + alugado + "]";
	}
	
	
	
}
