package com.blog.service;

import com.blog.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NotesService {
    Note save(Note note);

    Optional<Note> findById(Long id);

    List<Note> findAll();
}
