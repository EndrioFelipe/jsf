package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@ManagedBean //Implicitamente o ManagedBean realiza um RequestScoped que faz com que o objeto s� dure por apenas uma requisi��o
@ViewScoped //d� um erro de execu��o ap�s clicarmos em gravar, qdo fazemos isso
//criamos uma nova requisi��o q consequentemente cria um novo objeto para o livro, pois a vida do ManagedBean dura apenas um request. 
//Para contornar isso, colocamos ViewScoped para a requisi��o ter uma sobrevida q dure mais de um request, pelo menos enquanto a tela existir.
public class LivroBean {

	private Livro livro = new Livro();
	private Integer autorId;	

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Livro getLivro() {
		return livro;
	}
	
	public List<Autor> getAutores() {
        return new DAO<Autor>(Autor.class).listaTodos();
    }
	
	public List<Livro> getLivros() {
        return new DAO<Livro>(Livro.class).listaTodos();
    }

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			//throw new RuntimeException("Livro deve ter pelo menos um Autor.");
			
			//esse "auto" � o mesmo do id do inputtext
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("o Livro de ter pelo menos um autor."));
			return; //interrompe o m�todo e n�o grava o livro
		}

		new DAO<Livro>(Livro.class).adiciona(this.livro);
		
		this.livro = new Livro();
	}
	
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
	}
	
	public void gravarAutor() {
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
	}
	
	//vamos criar um validator personalizado
	//FacesContext fc ->  objeto que permite obter informa��es da view processada no momento
	//UIComponent component -> componente da view que est� sendo validado.
	//Object value -> valor digitado pelo usu�rio
	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {

	    String valor = value.toString();
	    if (!valor.startsWith("1")) {
	        throw new ValidatorException(new FacesMessage("Deveria come�ar com 1"));
	    }
	}

}
