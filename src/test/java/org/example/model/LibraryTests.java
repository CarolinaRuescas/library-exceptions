package org.example.model;

import org.ies.library.model.Book;
import org.ies.library.model.Library;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LibraryTests {


    private Library createTestLibrary(){
        return new Library(
                "Biblioteca Tierno Galvan",
                Map.of(
                        "1", new Book(
                                "1", "el Padrino", "Alguien", Set.of("Novela", "Miedo"),
                        )
                ),
                Map.of(

                ),
                List.of(

                )
        );
    }
}
