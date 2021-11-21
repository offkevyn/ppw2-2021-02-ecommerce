package br.edu.iftm.ecommerce.bean.converter;

import br.edu.iftm.ecommerce.logic.CategoriaLogic;
import br.edu.iftm.ecommerce.model.Categoria;
import br.edu.iftm.ecommerce.repository.CategoriaRepository;
import br.edu.iftm.ecommerce.util.JSFUtil;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter extends JSFUtil implements Converter<Categoria>{

    @Inject
    private CategoriaLogic logic;

    @Override
    public Categoria getAsObject(FacesContext fc, UIComponent uic, String idString) {
       Categoria categoria = 
                    (Categoria)uic.getAttributes().get("categoria_"+idString);
       return categoria;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Categoria categoria) {
        if(categoria != null && categoria.getId() != null){
            uic.getAttributes().put("categoria_"+categoria.getId(), categoria);
            return categoria.getId().toString();
        }
        return "";
    }

}