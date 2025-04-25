package org.ies.library.components;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.library.model.Book;
import org.ies.library.model.Genre;

import java.util.ArrayList;
import java.util.Scanner;

@Log4j
@AllArgsConstructor
public class BookReader implements  Reader<Book>{
    private final Scanner scanner;
    private final GenreReader genreReader;

    @Override
    public Book read() {
        log.info("DATOS DEL LIBRO");
        log.info("Introduce el ISBN: ");
        String isbn = scanner.nextLine();

        log.info("Introduce el título: ");
        String title = scanner.nextLine();

        log.info("Introduce el autor: ");
        String author = scanner.nextLine();

        log.info("¿Cuántos géneros quieres buscar");
        var genres = new ArrayList<Genre>();
        int numGenres = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numGenres; i++) {
            genres.add(genreReader.read());
        }

        return new Book(
                isbn,
                title,
                author,
                genres
        );

    }
}
