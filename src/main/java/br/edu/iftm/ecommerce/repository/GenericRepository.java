package br.edu.iftm.ecommerce.repository;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import lombok.Getter;

public class GenericRepository<E, ID extends Serializable> implements Serializable {

    @Inject
    private EntityManager entityManager;

    @Getter
    private Class<E> classeEntidade;

    public GenericRepository(Class<E> classeEntidade) {
        this.classeEntidade = classeEntidade;
    }

    public E save(E entidade) {
        this.entityManager.getTransaction().begin();
        entidade = this.entityManager.merge(entidade);
        this.entityManager.getTransaction().commit();
        return entidade;
    }

    public void remove(ID id) {
        E entidade = this.entityManager.find(getClasseEntidade(), id);
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(entidade);
        this.entityManager.getTransaction().commit();
    }

    public E findByID(ID id) {
        E entidade = this.entityManager.find(getClasseEntidade(), id);
        return entidade;
    }
    
    public List<E> list(){
        StringBuilder query = new StringBuilder("select e from ");
        query.append(getClasseEntidade().getName());
        query.append(" e");
        List<E> entidades = this.entityManager.createQuery(query.toString()).getResultList();
        return entidades;
    }
}
