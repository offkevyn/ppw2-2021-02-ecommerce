package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Permissao;
import br.edu.iftm.ecommerce.repository.PermissaoRepository;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class PermissaoLogic implements CrudLogic<Permissao>{

    @Inject
    private PermissaoRepository repository;

    @Override
    public Permissao salvar(Permissao entidade) throws ErroSistemaException, ErroNegocioException{
        if("".equals(entidade.getNome())) {
            throw new ErroNegocioException("Por favor informe o nome.");
        }
        entidade = this.repository.save(entidade);
        return entidade;
    }

    @Override
    public void remover(Permissao entidade) throws ErroSistemaException, ErroNegocioException{
        this.repository.remove(entidade.getId());
    }

    @Override
    public Permissao buscarPorId(Permissao entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.findByID(entidade.getId());
    }

    @Override
    public List<Permissao> buscar(Permissao entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.list();
    }


}
