package com.blog.service;

import com.blog.model.Note;
import com.blog.model.Person;
import com.blog.publisher.CommentPublisher;
import com.blog.repository.NoteRepository;
import com.blog.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NotesServiceImpl implements NotesService {

    private NoteRepository noteRepository;
    private PersonRepository personRepository;
    private CommentPublisher notePublisher;

    public NotesServiceImpl(NoteRepository noteRepository, PersonRepository personRepository, CommentPublisher notePublisher) {
        this.noteRepository = noteRepository;
        this.personRepository = personRepository;
        this.notePublisher = notePublisher;
    }

    @Override
    public Note save(Note note) {
        List<Person> authors = personRepository.findByName(note.getAuthor().getName());
        if (authors.size() == 1) {
            note.setAuthor(authors.get(0));
        } else {
            Person author = personRepository.save(note.getAuthor());
            note.setAuthor(author);
        }
        Note savedNote = noteRepository.save(note);
        notePublisher.publish(savedNote);
        return savedNote;
    }

    @Override
    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }
}