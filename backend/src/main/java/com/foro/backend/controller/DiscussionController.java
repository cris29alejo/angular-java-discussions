package com.foro.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.backend.model.Discussion;
import com.foro.backend.service.DiscussionService;

@RestController
@RequestMapping("/api/discussions")
@CrossOrigin(origins = "*") // Permite peticiones desde Angular en localhost
public class DiscussionController {

    private final DiscussionService discussionService;

    @Autowired
    public DiscussionController(DiscussionService discussionService) {
        this.discussionService = discussionService;
    }

    // Obtener todas las discusiones
    @GetMapping
    public List<Discussion> getAllDiscussions() {
        return discussionService.getAllDiscussions();
    }

    // Agregar una nueva discusión o respuesta
    @PostMapping
    public void addDiscussion(@RequestBody Discussion discussion) {
        discussionService.addDiscussion(discussion);
    }
}