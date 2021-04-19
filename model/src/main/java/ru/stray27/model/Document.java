package ru.stray27.model;

import lombok.Data;

@Data
public class Document {
    private Long id;
    private String documentName;
    private DocumentType documentType;
    private Importance importance;
}
