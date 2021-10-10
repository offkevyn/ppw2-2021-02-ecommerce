package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.PermissaoLogic;
import br.edu.iftm.ecommerce.model.Permissao;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PermissaoBean extends CrudBean<Permissao, PermissaoLogic> {

    @Inject
    private PermissaoLogic logic;

    public PermissaoBean() {
        super(Permissao.class);
    }

    @Override
    public PermissaoLogic getLogic() {
        return this.logic;
    }



}
