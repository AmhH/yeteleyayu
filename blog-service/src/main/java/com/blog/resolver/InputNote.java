package com.blog.resolver;

import com.blog.model.Note;
import com.blog.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputNote {
    private String note;

    static Note convert(InputNote comment, InputPerson person) {
        Person author = InputPerson.convert(person);
        return comment != null ? new Note(comment.getNote(), ZonedDateTime.now(), author) : null;
    }
}
