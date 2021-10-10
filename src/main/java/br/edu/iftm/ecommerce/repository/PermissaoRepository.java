package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.Permissao;

public class PermissaoRepository extends GenericRepository<Permissao, Integer>{

    public PermissaoRepository() {
        super(Permissao.class);
    }

}
