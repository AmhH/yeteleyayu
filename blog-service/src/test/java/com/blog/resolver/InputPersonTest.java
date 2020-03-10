package com.blog.resolver;

import com.blog.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InputPersonTest {
    @Test
    public void converterTest() {
        InputPerson inputPerson = new InputPerson("me", "noreply@me.com");
        Person person = InputPerson.convert(inputPerson);
        assertEquals(inputPerson.getName(), person.getName());
        assertEquals(inputPerson.getEmail(), person.getEmail());
    }

    @Test
    public void converterTestNull() {
        Person person = InputPerson.convert(null);
        assertNull(person);
    }
}
