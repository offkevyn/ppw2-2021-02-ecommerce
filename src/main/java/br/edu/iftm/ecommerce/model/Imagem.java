package br.edu.iftm.ecommerce.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

@Entity
@Table(name="imagem")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Imagem implements Serializable{
        
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String codigo;
    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Transient
    private UploadedFile file;
}
