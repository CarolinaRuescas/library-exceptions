package org.ies.library.components;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.library.exceptions.BookNotFoundException;
import org.ies.library.model.Library;

import java.util.InputMismatchException;
import java.util.Scanner;


@Log4j

public class LibraryApp {
    private final Scanner scanner;
    private final Library library;

    public LibraryApp(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
    }


    public void run(){
        int option;
        do{
            option = chooseOption();
            if(option ==1){
                library.showAllBooks();

            }else if (option == 2){
                library.showAllMember();
            }else if (option ==3){
                try {
                    log.info("Introduce el ISBN de libro que quieres buscar: ");
                    String isbn = scanner.nextLine();

                    var book = library.foundBookByIsbn(isbn);
                    log.info(book);
                }catch (BookNotFoundException e){
                    log.error(e.getMessage());
                }
            }else if (option == 4){
                try {
                    log.info("Introduce el nif para buscar al socio: ");
                }
            }
        }

    }

    private int chooseOption(){
        int option = 0;
        do{
            try{
                log.info("ELIGE UNA DE LAS OPCIONES");
                log.info("1. Mostrar Libros");
                log.info("2. Mostrar Socios");
                log.info("3. Ver libro");
                log.info("4. Existe prestamos");

                option = scanner.nextInt();
                if (option <1 || option >4){
                    log.error("La opción es inválida");
                }
            }catch (InputMismatchException e){
                log.error("Debes introducir una de las opciónes que se muestran");
            }finally {
                scanner.nextLine();
            }
        }while (option != 1 && option != 2 && option != 3 && option != 4);

        return option;
    }







}



