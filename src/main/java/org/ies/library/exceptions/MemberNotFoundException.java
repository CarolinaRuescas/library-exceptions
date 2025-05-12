package org.ies.library.exceptions;


import lombok.Getter;

@Getter
public class MemberNotFoundException extends Exception {
    private final String nif;

    public MemberNotFoundException(String nif) {
        super("No se ha encontrado al miembro con el NIF " + nif);

        this.nif = nif;
    }
}
