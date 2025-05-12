package org.ies.library.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.ies.library.exceptions.BookNotFoundException;
import org.ies.library.exceptions.MemberNotFoundException;

import java.util.Map;
import java.util.TreeSet;

@Data
@AllArgsConstructor
@Log4j

public class Library {
    private String name;
    private Map<String,Book> bookByIsbn;
    private Map<String,Member> memberByNif;
    private TreeSet<BookLend> bookLendsHistory;

    // metodo que muestra todos los libros
    public void showAllBooks (){
        for (var book : bookByIsbn.values()){
            log.info(book);
        }
    }

    // metodo que muestra todos los socios
    public void showAllMember(){
        for (var member : memberByNif.values()){
            log.info(member);
        }
    }

    // metodo que dado un ISBN devulve el libro. Si no existe el libro se lanza la excepcion
    // BookNotFOundException(isbn)
    public Book foundBookByIsbn (String isbn) throws BookNotFoundException{
        if (bookByIsbn.containsKey(isbn)){
            return bookByIsbn.get(isbn);
        }else{
            throw new BookNotFoundException(isbn);
        }
    }

    // Dado un nif, devuelve el socio. Si no existe MemberNotFoundException(nif)
    public Member foundMemberByNif (String nif) throws MemberNotFoundException{
        if(memberByNif.containsKey(nif)){
            return memberByNif.get(nif);
        }else{
            throw new MemberNotFoundException(nif);
        }
    }

    // Un metodo que devuelva un booleano que comprube si, dado un nif y un isbn,
    // el socio ha tomado prestado un libro. Si no existe el socio MemberNotFoundException(nif)
    // y si no existe el libro BookNotFoundException(isbn)

    public boolean memberMakesLoan (String nif, String isbn) throws BookNotFoundException, MemberNotFoundException{
        var member = foundMemberByNif(nif);
        var book = foundBookByIsbn(isbn);

        if(member != null){
            if(book != null){
                return true;
            }
        }else{
            throw new MemberNotFoundException(nif);
        }
        return false;

    }







}
