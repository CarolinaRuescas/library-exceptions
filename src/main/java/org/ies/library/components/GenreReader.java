package org.ies.library.components;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.library.model.Genre;

import java.util.Scanner;

@Log4j
@AllArgsConstructor
public class GenreReader implements Reader<Genre>{
    private final Scanner scanner;

    @Override
    public Genre read() {
        log.info("DATOS GENERO LIBRO");
        log.info("Intorduce el nombre del género: ");
        String name = scanner.nextLine();

        return new Genre(
                name
        );
    }
}
