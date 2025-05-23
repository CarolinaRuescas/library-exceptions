package org.ies.library.model;



import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Comparator;

@Data
@AllArgsConstructor

public class BookLend implements Comparable<BookLend>{
    private static Comparator<BookLend> comparator = Comparator.comparing(BookLend::getNifPartner).thenComparing(BookLend::getIsbn).thenComparing(BookLend::getDateLoan);
    private String isbn;
    private LocalDate dateLoan;
    private String nifPartner;
    private LocalDate dateReturn;



    @Override
    public int compareTo(BookLend bookLend) {
        return comparator.compare(this,bookLend);
    }
}
