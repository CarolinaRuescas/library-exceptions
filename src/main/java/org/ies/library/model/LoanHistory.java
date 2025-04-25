package org.ies.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class LoanHistory {
    private String isbn;
    private LocalDate dateLoan;
    private String nifPartner;
    private LocalDate dateReturn;

}
