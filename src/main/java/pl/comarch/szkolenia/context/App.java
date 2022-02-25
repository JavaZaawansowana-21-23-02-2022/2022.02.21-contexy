package pl.comarch.szkolenia.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.comarch.szkolenia.context.configuration.AppConfiguration;
import pl.comarch.szkolenia.context.gui.GUI;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        GUI gui  = context.getBean(GUI.class);
        gui.register();
        gui.authenticate();
    }
}
