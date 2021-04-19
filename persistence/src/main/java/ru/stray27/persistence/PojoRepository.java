package ru.stray27.persistence;

import java.util.List;

public interface PojoRepository<T, ID> {
    void save(T entity);
    void saveAll(List<T> entities);
    T find(ID id);
    List<T> findAll();
    void delete(ID id);
    void deleteAll();
}
