package com.blog.resolver;

import com.blog.model.Note;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class InputNoteTest {
    @Test
    public void converterTest() {
        InputNote inputNote = new InputNote("test");
        Note note = InputNote.convert(inputNote, null);
        assertEquals(inputNote.getNote(), note.getNote());
    }

    @Test
    public void converterTestNull() {
        Note note = InputNote.convert(null, null);
        assertNull(note);
    }
}
