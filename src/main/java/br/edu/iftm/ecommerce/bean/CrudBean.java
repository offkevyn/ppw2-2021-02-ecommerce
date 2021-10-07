package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.CrudLogic;
import br.edu.iftm.ecommerce.util.JSFUtil;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CrudBean<E, L extends CrudLogic<E>> extends JSFUtil{
    private EstadoDaTela estadoDaTela = EstadoDaTela.BUSCAR;
    private E entidade;
    private List<E> entidades = new ArrayList<>();
    private L logic;
    private Class<E> classeEntidade;
    
    public CrudBean (Class<E> classeEntidade)
    {
        this.classeEntidade = classeEntidade;
    }
    
    public enum EstadoDaTela
    {
        BUSCAR,
        INSERIR,
        ATUALIZAR
    }
    
    public void novo()
    {
        try {
            this.entidade = this.classeEntidade.newInstance();
            this.estadoDaTela = EstadoDaTela.INSERIR;
        } catch (InstantiationException ex) {
            addErro("Erro ao criar instância.");
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            addErro("Erro ao criar instância.");
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar()
    {
        try {
            this.getLogic().salvar(entidade);
            buscar();
            addInfo("Salvo com sucesso.");
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void editar(E entidade)
    {
        try {
            this.entidade = this.getLogic().buscarPorId(entidade);
            this.setEstadoDaTela(EstadoDaTela.ATUALIZAR);
        } catch (ErroNegocioException ex) {
           addAviso(ex);
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void remover(E entidade)
    {
        try {
            this.getLogic().remover(entidade);
            this.entidades.remove(entidade);
            addInfo("Removido com sucesso.");
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }  catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void buscar()
    {
        if(!this.estadoDaTela.equals(EstadoDaTela.BUSCAR))
        {
            this.estadoDaTela = EstadoDaTela.BUSCAR;
        }
        else
        {
            try {
                this.entidades = getLogic().buscar(null);
            } catch (ErroNegocioException ex) {
                addAviso(ex);
            } catch (ErroSistemaException ex) {
                 addErro(ex);
                Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        
    }

    public EstadoDaTela getEstadoDaTela() {
        return estadoDaTela;
    }

    public void setEstadoDaTela(EstadoDaTela estadoDaTela) {
        this.estadoDaTela = estadoDaTela;
    }

    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }

    public abstract L getLogic();
    
    
}
