package br.com.impacta.springmvc.gerenciadordespesas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author di4505
 *
 */
@Entity
public class Livros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_livro;
	
	private String titulo;
	
	private String genero;
	
	private String autor;
	
	private Double valor;

	public int getId_livro() {
		return id_livro;
	}

	public void setId_livro(int id_livro) {
		this.id_livro = id_livro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	

}
