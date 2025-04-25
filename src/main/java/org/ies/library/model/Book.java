package org.ies.library.model;

import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;
    private String author;
    private List<String> genres;
}
