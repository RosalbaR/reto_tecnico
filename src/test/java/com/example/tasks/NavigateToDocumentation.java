package com.example.tasks;

import com.example.ui.pages.SeleniumHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

// Task que simula la navegación hacia el menú Documentation del sitio.
// Esta acción sirve para validar que la navegación principal funciona correctamente.
public class NavigateToDocumentation implements Task {

    private final String linkText;

    // Constructor con el texto del enlace que se desea abrir.
    public NavigateToDocumentation(String linkText) {
        this.linkText = linkText;
    }

    // performAs ejecuta el clic sobre un elemento identificado dinámicamente por su texto.
    @Override
    public <T extends Actor> void performAs(T actor) {
        Target dynamicLink = Target.the("link por texto").locatedBy("//a[text()='" + linkText + "']");
        actor.attemptsTo(Click.on(dynamicLink));
    }

    // Método estático de conveniencia para que el step definition lea mejor la intención del caso.
    public static NavigateToDocumentation byLinkText(String linkText) {
        return new NavigateToDocumentation(linkText);
    }
}
