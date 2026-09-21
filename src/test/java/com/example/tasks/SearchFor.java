package com.example.tasks;

import com.example.ui.pages.SeleniumHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchFor implements Task {

    private final String term;

    public SearchFor(String term) {
        this.term = term;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SeleniumHomePage.SEARCH_BUTTON),
                WaitUntil.the(SeleniumHomePage.INPUT_SEARCH, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(term).into(SeleniumHomePage.INPUT_SEARCH),
                Hit.the(Keys.ENTER).into(SeleniumHomePage.INPUT_SEARCH)
        );
    }

    public static SearchFor term(String term) {
        return new SearchFor(term);
    }
}
