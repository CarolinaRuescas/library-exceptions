package org.ies.library.model;

import org.ies.library.exceptions.BookNotFoundException;
import org.ies.library.exceptions.MemberNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class LibraryTests {


    private Library createTestsLibrary(){

        Map<String, Book> bookByIsbn = Map.of(
                "533", new Book("533", "Busqueda", "Adrian", List.of(
                        "Miedo", "Romance")
                ),
                "534", new Book("534", "Campo", "Adrian", List.of(
                        "Miedo", "Romance")
                )

        );
        Map<String, Member> memberByNif = Map.of(
                "4x", new Member("4x", "Carolina", "Ruescas", 1, 28943),
                "5x", new Member("5x", "Yolanda", "Perez", 2, 28944)
        );

        TreeSet<BookLend> bookLendsHistory = new TreeSet<>();
        bookLendsHistory.add(new BookLend("533", LocalDate.now(), "4x", LocalDate.now()));
        bookLendsHistory.add(new BookLend("534", LocalDate.now(), "5x", LocalDate.now()));

        return new Library(
                "Pepita Pérez",
                bookByIsbn,
                memberByNif,
                bookLendsHistory
        );
    }

    // metodo que dado un ISBN devulve el libro. Si no existe el libro se
    // lanza la excepcion BookNotFOundException(isbn)
    // Se dan dos opciones, que se encuentre el libro o que no se encuentre

    // 1º Se encuentra el libro
    @Test
    public void findBookTest() throws BookNotFoundException {
        var library = createTestsLibrary();
        var result = library.findBookByIsbn("533");
        var expected = new Book("533", "Busqueda", "Adrian", List.of(
                "Miedo", "Romance"));

        Assertions.assertEquals(result, expected);
    }

    // 2º No se encuentra el libro
    @Test
    public void findBookNotFoundBookTest (){
        Assertions.assertThrows(
                BookNotFoundException.class,
                ()->{
                    var library = createTestsLibrary();
                    library.findBookByIsbn("200");
                }
        );
    }

    // Dado un nif, devuelve el socio. Si no existe MemberNotFoundException(nif)
    // 1º existe el socio
    @Test
    public void findMemberTest()throws MemberNotFoundException{
        var library = createTestsLibrary();
        var result = library.findMemberByNif("4x");
        var expected = new Member("4x", "Carolina", "Ruescas", 1, 28943);
        Assertions.assertEquals(result, expected);
    }

    // 2º No existe el socio
    @Test
    public void findMemberNotFoundTest(){
        Assertions.assertThrows(
                MemberNotFoundException.class,
                ()->{
                    var library = createTestsLibrary();
                    library.findMemberByNif("9x");
                }
        );
    }

    // Un metodo que devuelva un booleano que comprube si, dado un nif y un isbn,
    // el socio ha tomado prestado un libro. Si no existe el socio MemberNotFoundException(nif)
    // y si no existe el libro BookNotFoundException(isbn) SALEN 4 escenarios

    // 1º Existe el socio y el libro que ha prestado, pero uno tiene que ser true y otro false porque
    // puede pasar que el socio exista pero que el libro introducido no lo haya cogido el sino el otro (false)
    @Test
    public void findMemberfindBookTrueTest()throws MemberNotFoundException, BookNotFoundException{
        var library = createTestsLibrary();
        var resul = library.memberMakesLoan("533", "4x");
        Assertions.assertTrue(resul);
    }

    // 2º escenario
    @Test
    public void findMemberfindBookFalseTest()throws MemberNotFoundException, BookNotFoundException {
        var library = createTestsLibrary();
        var resul = library.memberMakesLoan("534", "4x");
        Assertions.assertFalse(resul);
    }


    // 3º Existe el libro pero no el socio (por los datos hardcodeados anteriores)
    @Test
    public void memberMakesLoanMemberNotFoundTest(){
        Assertions.assertThrows(
                MemberNotFoundException.class,
                ()->{
                    var library = createTestsLibrary();
                    library.memberMakesLoan("533","12x");
                }
        );
    }

    // 4º con este test se comprueba que el libro no ocincide pero si que coincida el socio
    @Test
    public void memberMakesLoanBookNotFoundTest(){
        Assertions.assertThrows(
                BookNotFoundException.class,
                ()->{
                    var library = createTestsLibrary();
                    library.memberMakesLoan("600","4x");
                }
        );
    }




















}
