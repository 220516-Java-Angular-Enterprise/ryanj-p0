package com.revature.mtbbros.daos;


import java.util.List;

// Using generics - <T> (Typecast)
public interface CrudDAO<T> {
    // Create Read Update Delete Data Access Object
    void save(T obj);

    void update(T obj);
    void delete(String id);

    T getById(String id);
    List<T> getAll();
}
