package com.example.questions;

import com.example.ui.pages.SeleniumHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebElement;

public class SearchResultsContain implements Question<Boolean> {

    private final String term;

    public SearchResultsContain(String term) {
        this.term = term;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String text = SeleniumHomePage.SEARCH_RESULTS.resolveFor(actor).getText();
        return text != null && text.toLowerCase().contains(term.toLowerCase());
    }

    public static boolean of(Actor actor, String term) {
        return new SearchResultsContain(term).answeredBy(actor);
    }
}
