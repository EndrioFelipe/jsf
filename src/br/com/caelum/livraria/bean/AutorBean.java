package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public RedirectView gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		//new DAO<Autor>(Autor.class).adiciona(this.autor);
		
		this.autor = new Autor();
		//O controlador do JSF, ao encontrar um tipo diferente de String, chamará o método toString() em busca do nome da View
		
		System.out.println(new RedirectView("nada").toString());
		System.out.println("redirecionamento: "+new RedirectView("livro"));
		
		return new RedirectView("livro");
	}
}
