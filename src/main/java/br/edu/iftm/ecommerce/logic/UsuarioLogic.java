package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Usuario;
import br.edu.iftm.ecommerce.repository.UsuarioRepository;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class UsuarioLogic implements CrudLogic<Usuario>{

    @Inject
    private UsuarioRepository repository;
    
    @Override
    public Usuario salvar(Usuario entidade) throws ErroSistemaException, ErroNegocioException{
        if("".equals(entidade.getNome()))
        {
            throw new ErroNegocioException("Por favor informe o nome.");
        }
        if(entidade.getDataCadastro() == null)
        {
            entidade.setDataCadastro(new Date());
        }
        entidade = (Usuario) this.repository.save(entidade);
        return entidade;
    }

    @Override
    public void remover(Usuario entidade) throws ErroSistemaException, ErroNegocioException{
        this.repository.remove(entidade.getId());
    }

    @Override
    public Usuario buscarPorId(Usuario entidade) throws ErroSistemaException, ErroNegocioException{
        return (Usuario) this.repository.findByID(entidade.getId());
    }

    @Override
    public List<Usuario> buscar(Usuario entidade) throws ErroSistemaException, ErroNegocioException{
        return this.repository.list();
    }

 
    
}
