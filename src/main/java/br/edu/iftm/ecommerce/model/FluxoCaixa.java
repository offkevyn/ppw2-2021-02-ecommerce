package br.edu.iftm.ecommerce.model;

import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FluxoCaixa {
    
    @EqualsAndHashCode.Include
    private Integer id;
    private String descricao;
    private String tipoMovimento;
    private float valor;
    private Date dataMovimento;
}
