package org.ies.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Partner {
    private String nif;
    private String name;
    private String surname;
    private int numberPartner;
    private int zipCode;
}
