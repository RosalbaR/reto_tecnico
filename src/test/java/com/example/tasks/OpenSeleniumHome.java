package com.example.tasks;

import com.example.ui.pages.SeleniumHomePage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Actor;

// Task que representa la acción de abrir la página principal del sitio.
// En Screenplay, una Task describe una responsabilidad que el Actor realiza.
public class OpenSeleniumHome implements Task {

    // performAs es el punto de ejecución de la tarea.
    // Aquí se abre la URL pública de Selenium para iniciar el flujo web.
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url("https://selenium.dev"));
    }

    // Factory method para crear la Task de manera más legible desde los step definitions.
    // Ejemplo: actor.attemptsTo(OpenSeleniumHome.onTheHomePage());
    public static OpenSeleniumHome onTheHomePage() {
        return new OpenSeleniumHome();
    }
}
