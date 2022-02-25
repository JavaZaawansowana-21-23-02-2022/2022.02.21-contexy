package pl.comarch.szkolenia.context.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.context.Authenticator;
import pl.comarch.szkolenia.context.Registrator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class GUI {

    @Autowired
    Authenticator authenticator;

    @Autowired
    Registrator registrator;

    public void authenticate() throws IOException {
        System.out.println("Wprowadz login:");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String login = reader.readLine();

        System.out.println("Wprowadz haslo:");
        String pass = reader.readLine();

        boolean authResult = this.authenticator.authenticate(login, pass);

        if(authResult) {
            System.out.println("Udało się !!!");
        } else {
            System.out.println("Nie udało się !!!");
        }

    }

    public void register() throws IOException {
        System.out.println("Wprowadz login:");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String login = reader.readLine();

        System.out.println("Wprowadz haslo:");
        String pass = reader.readLine();

        boolean registerResult = this.registrator.register(login, pass);

        if(registerResult) {
            System.out.println("Zarejestrowano !!!");
        } else {
            System.out.println("Nie udało się zarejestrować !!!");
        }
    }
}
