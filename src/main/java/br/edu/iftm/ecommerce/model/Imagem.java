package br.edu.iftm.ecommerce.model;

import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Imagem {
        
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private String codigo;
    private Date dataCriacao;

}
