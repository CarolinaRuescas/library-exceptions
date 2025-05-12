package org.ies.library.model;



import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookLend {
    private String isbn;
    private LocalDate dateLoan;
    private String nifPartner;
    private LocalDate dateReturn;

}
