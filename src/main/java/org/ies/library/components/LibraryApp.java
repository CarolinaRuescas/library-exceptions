package org.ies.library.components;


import lombok.extern.log4j.Log4j;
import org.ies.library.exceptions.BookNotFoundException;
import org.ies.library.exceptions.MemberNotFoundException;
import org.ies.library.model.Book;
import org.ies.library.model.BookLend;
import org.ies.library.model.Library;
import org.ies.library.model.Member;

import java.time.LocalDate;
import java.util.*;


@Log4j

public class LibraryApp {
    private final Scanner scanner;


    public LibraryApp(Scanner scanner) {
        this.scanner = scanner;
    }


    public void run(){
        var library = createTestsLibrary();
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

                    var book = library.findBookByIsbn(isbn);
                    log.info(book);
                }catch (BookNotFoundException e){
                    log.error(e.getMessage());
                }
            }else if (option == 4){
                try {
                    log.info("Introduce el nif para buscar al socio: ");
                    String nif = scanner.nextLine();

                    log.info("Intorduce el ISBN: ");
                    String isbn = scanner.nextLine();

                    var loan = library.memberMakesLoan(nif, isbn);
                    log.info(loan);

                }catch (MemberNotFoundException | BookNotFoundException e){
                    log.error(e.getMessage());
                }
            }else{
                log.info("Saliendo....");
            }
        }while (option != 5);

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

    private Library createTestsLibrary(){

        Map<String, Book> bookByIsbn = Map.of(
                "533", new Book("533", "Busqueda", "Adrian", List.of(
                        "Miedo", "Romance")
                )
        );
        Map<String, Member> memberByNif = Map.of(
                "4x", new Member("4x", "Carolina", "Ruescas", 1, 28943),
                "5x", new Member("5x", "Yolanda", "Perez", 2, 28944)
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



