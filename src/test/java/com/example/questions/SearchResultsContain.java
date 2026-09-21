package com.example.questions;

import com.example.ui.pages.SeleniumHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebElement;

// Question que valida si los resultados de búsqueda contienen el texto esperado.
// Sirve para confirmarle al QA que la búsqueda realmente devolvió algo útil.
public class SearchResultsContain implements Question<Boolean> {

    private final String term;

    // Constructor con el término que debe estar presente en los resultados.
    public SearchResultsContain(String term) {
        this.term = term;
    }

    // answeredBy recupera el texto visible del contenedor de resultados y compara el contenido.
    @Override
    public Boolean answeredBy(Actor actor) {
        String text = SeleniumHomePage.SEARCH_RESULTS.resolveFor(actor).getText();
        return text != null && text.toLowerCase().contains(term.toLowerCase());
    }

    // Método factory para simplificar la validación desde el step definition.
    public static boolean of(Actor actor, String term) {
        return new SearchResultsContain(term).answeredBy(actor);
    }
}
