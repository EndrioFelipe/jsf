package br.com.caelum.livraria.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro {

	@Id
	@GeneratedValue
	private Integer id;

	private String titulo;
	private String isbn;
	private double preco;
	
	//@Temporal(TemporalType.DATE) //ignorar o horário no banco de dados e considera apenas a data
	@Temporal(TemporalType.TIMESTAMP) //esse considera as horas. No pattern da view vamos ter: pattern="dd/MM/yyyy HH:mm"
	private Calendar dataLancamento = Calendar.getInstance();

	@ManyToMany(fetch=FetchType.EAGER) //aqui, na hora de carregar o livro para não dar LazyInitialiazationException, pq o restante do livro era carregado na tela de formulário, mas 
	//não carregava os autores
	private List<Autor> autores = new ArrayList<Autor>();

	public List<Autor> getAutores() {
		return autores;
	}

	public void adicionaAutor(Autor autor) {
		this.autores.add(autor);
	}

	public Livro() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	
}