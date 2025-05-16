package com.foro.backend.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discussion {
    private String id;
    private String author;
    private String content;
    private String parentId;
    private List<Discussion> replies;
}