package org.ies.library.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.library.components.LoanHistoryReader;
import org.ies.library.components.PartnerReader;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Library {
    private String name;
    private Map<String, Book> books;
    private Map<String, Partner> partners;
    private List<LoanHistory> loanHistories;


}
