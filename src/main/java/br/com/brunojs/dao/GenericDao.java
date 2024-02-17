package br.com.brunojs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDao implements  IGenericDao{
    @Override
    public Object cadastrar(Object entity) {
        //** Conecta no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //** Abre a transacao
        entityManager.getTransaction().begin();
        //** Salva a entidade no banco
        entityManager.persist(entity);
        //** Salva a transacao
        entityManager.getTransaction().commit();

        //** Fecha a conexao
        entityManager.close();
        entityManagerFactory.close();

        return entity;
    }

    @Override
    public Object excluir(Object entity) {
        //** Conecta no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //** Abre a transacao
        entityManager.getTransaction().begin();
        //** Exclui a entidade no banco
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        //** Salva a transacao
        entityManager.getTransaction().commit();

        //** Fecha a conexao
        entityManager.close();
        entityManagerFactory.close();

        return entity;
    }
}
