package br.edu.iftm.ecommerce.bean;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloBean implements Serializable {
    
    private String nome;

    public void dizerOla(){
        FacesContext fc = FacesContext.getCurrentInstance();
        
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ola "+ nome, null);
        
        fc.addMessage(null, fm);
    }
    
    //Metodos get e set
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
