package br.edu.iftm.ecommerce.util;

import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil implements Serializable{
    
    public void addMensagem(FacesMessage.Severity severety, String sumary, String detail)
    {
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(severety, sumary, detail));
    }
    
    public void addInfo(String sumary, String detail)
    {
        addMensagem(FacesMessage.SEVERITY_INFO, sumary, detail);
    }
    
    public void addInfo(String mensagem)
    {
        addInfo("Info", mensagem);
                
    }
    
    public void addAviso(String sumary, String detail)
    {
        addMensagem(FacesMessage.SEVERITY_WARN, sumary, detail);
    }
    
    public void addAviso(String mensagem)
    {
        addAviso("Aviso", mensagem);          
    }
    
    public void addAviso(ErroNegocioException ex)
    {
        addAviso("Aviso", ex.getMessage());          
    }
    
    public void addErro(String sumary, String detail)
    {
        addMensagem(FacesMessage.SEVERITY_ERROR, sumary, detail);
    }
    
    public void addErro(String mensagem)
    {
        addErro("Erro", mensagem);          
    }
    
    public void addErro(ErroSistemaException ex)
    {
        addErro("Erro", ex.getMessage());          
    }
}
