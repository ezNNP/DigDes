package ru.stray27.persistence;

import lombok.extern.slf4j.Slf4j;
import ru.stray27.model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class UserRepository implements PojoRepository<User, Long> {

    private Map<Long, User> users = new ConcurrentHashMap<>();

    @Override
    public void save(User entity) {
        log.debug("Saving %s", entity.toString());
        users.put(entity.getId(), entity);
    }

    @Override
    public void saveAll(List<User> entities) {
        entities.forEach(this::save);
    }

    @Override
    public User find(Long id) {
        return users.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void delete(Long id) {
        users.remove(id);
    }

    @Override
    public void deleteAll() {
        users.clear();
    }
}
