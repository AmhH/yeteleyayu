package com.blog.publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class NoteUpdate {
    private String note;
    private String authorName;
    private String createdOn;
}
