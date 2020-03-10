package com.blog.resolver;

import com.blog.model.Note;
import com.blog.service.NotesService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private NotesService notesService;

    public Query(NotesService notesService) {
        this.notesService = notesService;
    }

    public Optional<Note> note(final Long id) {
        return notesService.findById(id);
    }

    public List<Note> notes() {
        return notesService.findAll();
    }
}
