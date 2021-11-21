package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Categoria;
import br.edu.iftm.ecommerce.repository.CategoriaRepository;
import br.edu.iftm.ecommerce.util.StringUtil;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class CategoriaLogic implements CrudLogic<Categoria> {

    @Inject
    private CategoriaRepository repository;

    @Override
    public Categoria salvar(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        if (StringUtil.isEmpty(entidade.getNome())) {
            throw new ErroNegocioException("Informe o nome.");
        }
        if(entidade.getCategoria() != null)
            System.err.println("\n\n================== nome - " + entidade.getNome() + " sub  - " + entidade.getCategoria().getNome() + "");
        else
            System.err.println("\n\n================== nome - " + entidade.getNome() +"");
        return this.repository.save(entidade);
    }

    @Override
    public void remover(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        this.repository.remove(entidade.getId());
    }
    
    @Override
    public Categoria buscarPorId(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.findByID(entidade.getId());
    }

    @Override
    public List<Categoria> buscar(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.list();
    }

}
