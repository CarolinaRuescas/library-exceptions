package org.ies.library.exceptions;

import lombok.Getter;

@Getter
public class BookNotFoundException extends Exception {
    private final String isbn;

    public BookNotFoundException(String isbn) {
        super("No existe ese libro con el ISBN " + isbn );
        this.isbn = isbn;
    }
}
