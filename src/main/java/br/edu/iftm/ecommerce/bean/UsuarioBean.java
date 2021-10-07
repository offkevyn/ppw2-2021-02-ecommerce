package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.CrudLogic;
import br.edu.iftm.ecommerce.logic.UsuarioLogic;
import br.edu.iftm.ecommerce.model.Usuario;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioLogic>{

    @Inject
    private UsuarioLogic logic;

    public UsuarioBean() {
        super(Usuario.class);
    }
    
    @Override
    public UsuarioLogic getLogic() {
        return this.logic;
    }
    
}
