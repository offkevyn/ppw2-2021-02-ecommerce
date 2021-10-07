package br.edu.iftm.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Marca {
    
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
}
