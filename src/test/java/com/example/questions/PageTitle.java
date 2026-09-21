package com.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

// Question que consulta el título de la página actual para verificar que la carga fue correcta.
// En Screenplay, las Questions son consultas sobre el estado del sistema.
public class PageTitle implements Question<String> {

    // answeredBy obtiene el título del navegador actual usando BrowseTheWeb.
    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getDriver().getTitle();
    }

    // Método estático para facilitar el uso desde Gherkin/steps.
    public static String value(Actor actor) {
        return new PageTitle().answeredBy(actor);
    }
}
