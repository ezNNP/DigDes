package ru.stray27.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class Directory {
    private Long id;
    private String directoryName;
    private User owner;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Directory parent;
    private List<Document> documents;
}
