package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.UsuarioLogic;
import br.edu.iftm.ecommerce.util.Constants;
import br.edu.iftm.ecommerce.util.JSFUtil;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class InfoBean extends JSFUtil {

    @Inject
    private UsuarioLogic logic;

    public InfoBean(){
        System.out.println("###############################");
        System.out.println("Construtor InfoBean");
        boolean existe = logic != null;
        System.out.println("Logic: " + existe);
    }

    @PostConstruct
    public void init(){
        System.out.println("###############################");
        System.out.println("PostConstruct InfoBean");
        boolean existe = logic != null;
        System.out.println("Logic: " + existe);
    }

    public String getVersao(){
        return Constants.VERSAO;
    }

    public String getCopyright(){
        return Constants.COPYRIGHT;
    }
}