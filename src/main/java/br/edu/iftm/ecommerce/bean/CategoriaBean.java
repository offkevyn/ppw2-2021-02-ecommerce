package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.CategoriaLogic;
import br.edu.iftm.ecommerce.model.Categoria;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class CategoriaBean extends CrudBean<Categoria, CategoriaLogic>{

    @Inject
    private CategoriaLogic logic;

    public CategoriaBean() {
        super(Categoria.class);
    }
    
    @Override
    public CategoriaLogic getLogic() {
        return this.logic;
    }
    
    public List<Categoria> listaCategorias()
    {
        try {
            return logic.buscar(null);
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
        return new ArrayList<>();
    }
    
}
