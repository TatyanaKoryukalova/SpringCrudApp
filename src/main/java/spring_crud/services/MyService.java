package spring_crud.services;

import spring_crud.entities.Persistable;

import java.util.List;

public interface MyService<T extends Persistable> {
    void create(T entity);

    String read(int id);

    void update(T entity, int id);

    void delete(int id);

//    List<T> findAll();

    List<T> getAll();
}
