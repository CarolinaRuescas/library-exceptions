package org.example.model;

import org.ies.library.model.Book;
import org.ies.library.model.Library;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

public class BookTest {
    @Test
    public void findBooktestPosiitve(){

    }

    private Library createLibrary(){
        return new Library(
                "biblioteca tierno",
                Map.of(
                        "1", new Book(
                                "1", "Hola", "Diego", Set.of("Novela"),
                        ),

                )
        )
    }

}
