package com.example.tasks;

import com.example.ui.pages.SeleniumHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

// Task que ejecuta la búsqueda de un término en la web.
// La idea es emular el comportamiento del usuario al escribir una palabra y presionar Enter.
public class SearchFor implements Task {

    private final String term;

    // Constructor que recibe el texto a buscar.
    public SearchFor(String term) {
        this.term = term;
    }

    // performAs escribe el texto dentro del campo de búsqueda y envia la acción ENTER.
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(term).into(SeleniumHomePage.INPUT_SEARCH),
                Hit.the(Keys.ENTER).into(SeleniumHomePage.INPUT_SEARCH)
        );
    }

    // Método de fábrica para lograr una lectura más natural en el step.
    public static SearchFor term(String term) {
        return new SearchFor(term);
    }
}
