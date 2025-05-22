package org.ies.library.model;

import java.time.LocalDate;
import java.util.*;

public class LibraryTests {

    // metodo que dado un ISBN devulve el libro. Si no existe el libro se
    // lanza la excepcion BookNotFOundException(isbn)


    private Library createTestsLibrary(){

        Map<String, Book> bookByIsbn = Map.of(
                "1X", new Book("533", "Busqueda", "Adrian", List.of(
                        "Miedo", "Romance")
                )
        );
        Map<String, Member> memberByNif = Map.of(
                "2x", new Member("4x", "Carolina", "Ruescas", 1, 28943),
                "3x", new Member("5x", "Yolanda", "Perez", 2, 28944)
        );

        TreeSet<BookLend> bookLendsHistory = new TreeSet<>();
        bookLendsHistory.add(new BookLend("100", LocalDate.now(), "4x", LocalDate.now()));

        return new Library(
                "Pepita Pérez",
                bookByIsbn,
                memberByNif,
                bookLendsHistory
        );






    }











}
