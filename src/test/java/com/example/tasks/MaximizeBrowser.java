package com.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class MaximizeBrowser implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().manage().window().maximize();
    }

    public static MaximizeBrowser window() {
        return new MaximizeBrowser();
    }
}
