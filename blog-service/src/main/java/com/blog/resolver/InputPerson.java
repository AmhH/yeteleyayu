package com.blog.resolver;

import com.blog.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputPerson {
    private String name;
    private String email;

    static Person convert(InputPerson person) {
        return person != null ? new Person(person.name, person.email) : null;
    }
}
