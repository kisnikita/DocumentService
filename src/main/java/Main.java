package main.java;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import main.java.view.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        new ConsoleMenu().start();
    }
}
