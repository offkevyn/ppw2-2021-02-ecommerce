package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.Categoria;

public class CategoriaRepository extends GenericRepository<Categoria, Integer>{

    public CategoriaRepository() {
        super(Categoria.class);
    }
}
