package ru.stray27.persistence;

import lombok.extern.slf4j.Slf4j;
import ru.stray27.model.Directory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class DirectoryRepository implements PojoRepository<Directory, Long> {

    private Map<Long, Directory> directories = new ConcurrentHashMap<>();

    @Override
    public void save(Directory entity) {
        log.debug("Saving %s", entity.toString());
        directories.put(entity.getId(), entity);
    }

    @Override
    public void saveAll(List<Directory> entities) {
        entities.forEach(this::save);
    }

    @Override
    public Directory find(Long id) {
        return directories.get(id);
    }

    @Override
    public List<Directory> findAll() {
        return new ArrayList<>(directories.values());
    }

    @Override
    public void delete(Long id) {
        directories.remove(id);
    }

    @Override
    public void deleteAll() {
        directories.clear();
    }
}
