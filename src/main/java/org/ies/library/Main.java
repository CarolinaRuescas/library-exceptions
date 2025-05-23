package org.ies.library;

import org.ies.library.components.LibraryApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       LibraryApp app = new LibraryApp(scanner);

        app.run();

    }
}