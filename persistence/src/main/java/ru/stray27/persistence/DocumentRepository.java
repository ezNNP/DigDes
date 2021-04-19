package ru.stray27.persistence;

import lombok.extern.slf4j.Slf4j;
import ru.stray27.model.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class DocumentRepository implements PojoRepository<Document, Long> {

    private Map<Long, Document> documents = new ConcurrentHashMap<>();

    @Override
    public void save(Document entity) {
        log.debug("Saving %s", entity.toString());
        documents.put(entity.getId(), entity);
    }

    @Override
    public void saveAll(List<Document> entities) {
        entities.forEach(this::save);
    }

    @Override
    public Document find(Long id) {
        return documents.get(id);
    }

    @Override
    public List<Document> findAll() {
        return new ArrayList<>(documents.values());
    }

    @Override
    public void delete(Long id) {
        documents.remove(id);
    }

    @Override
    public void deleteAll() {
        documents.clear();
    }
}
