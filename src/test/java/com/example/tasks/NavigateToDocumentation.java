package com.example.tasks;

import com.example.ui.pages.SeleniumHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class NavigateToDocumentation implements Task {

    private final String linkText;

    public NavigateToDocumentation(String linkText) {
        this.linkText = linkText;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SeleniumHomePage.LINK_DOCUMENTATION));
    }

    public static NavigateToDocumentation byLinkText(String linkText) {
        return new NavigateToDocumentation(linkText);
    }
}
