package com.example.tasks;

import com.example.ui.pages.SeleniumHomePage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Actor;

public class OpenSeleniumHome implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url("https://selenium.dev"));
    }

    public static OpenSeleniumHome onTheHomePage() {
        return new OpenSeleniumHome();
    }
}
