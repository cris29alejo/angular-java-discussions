package com.foro.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foro.backend.model.Discussion;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiscussionService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file = new File("src/main/resources/discussions.json");

    // Leer todas las discusiones desde el archivo JSON
    public List<Discussion> getAllDiscussions() {
        try {
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, new TypeReference<List<Discussion>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo JSON", e);
        }
    }

    // Guardar todas las discusiones en el archivo JSON
    public void saveAllDiscussions(List<Discussion> discussions) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, discussions);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo JSON", e);
        }
    }

    // Agregar una nueva discusión
    public void addDiscussion(Discussion discussion) {
        List<Discussion> discussions = getAllDiscussions();
        discussions.add(discussion);
        saveAllDiscussions(discussions);
    }
}