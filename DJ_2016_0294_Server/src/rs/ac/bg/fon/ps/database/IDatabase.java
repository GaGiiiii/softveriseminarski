/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.database;

import java.util.List;

/**
 *
 * @author GaGiiiii
 */
public interface IDatabase<T, K> {

//    public default void connect() throws Exception {
//        Database.getInstance().getConnection();
//    }
//
//    public default void disconnect() throws Exception {
//        Database.getInstance().getConnection().close();
//    }
//
//    default public void commit() throws Exception {
//        Database.getInstance().getConnection().commit();
//    }
//
//    default public void rollback() throws Exception {
//        Database.getInstance().getConnection().rollback();
//    }

    public void insert(T t) throws Exception;

    public void update(T t) throws Exception;

    public void delete(T t) throws Exception;

    public List<T> getAll() throws Exception;

    public List<T> getAll(T param) throws Exception;

    public T get(K k) throws Exception;

    public T get(K k, T t) throws Exception;
}
