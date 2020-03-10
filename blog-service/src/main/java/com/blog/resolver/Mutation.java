package com.blog.resolver;

import com.blog.model.Note;
import com.blog.service.NotesService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private NotesService notesService;

    public Mutation(NotesService notesService) {
        this.notesService = notesService;
    }

    public Note addNote(final InputNote note, final InputPerson author) {
        return notesService.save(InputNote.convert(note, author));
    }
}
