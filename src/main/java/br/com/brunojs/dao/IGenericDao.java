package br.com.brunojs.dao;

public interface IGenericDao<T> {

    public T cadastrar(T entity);

    public T excluir(T entity);
}
