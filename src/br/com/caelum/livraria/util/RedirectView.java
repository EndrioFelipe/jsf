package br.com.caelum.livraria.util;

public class RedirectView {

    private String viewName;

    public RedirectView(String viewName) {
        this.viewName = viewName;
    }

	@Override
	public String toString() {
		System.out.println("aqui");
		return viewName + "?faces-redirect=true";
	}  
    
    
}