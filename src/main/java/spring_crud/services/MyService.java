package spring_crud.services;

import spring_crud.entities.Persistable;

public interface MyService<T extends Persistable> {
    void create();

    void read();

    void update();

    void delete();
}
