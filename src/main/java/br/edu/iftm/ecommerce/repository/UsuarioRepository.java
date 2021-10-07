package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UsuarioRepository extends GenericRepository {
    
    public UsuarioRepository() {
        super(Usuario.class);
    }
}
