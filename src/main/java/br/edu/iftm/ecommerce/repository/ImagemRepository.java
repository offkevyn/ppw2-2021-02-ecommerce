package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.Imagem;

public class ImagemRepository extends GenericRepository<Imagem, Integer>{

    public ImagemRepository() {
        super(Imagem.class);
    }

}
