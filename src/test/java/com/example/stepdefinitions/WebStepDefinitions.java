package com.example.stepdefinitions;

import com.example.tasks.NavigateToDocumentation;
import com.example.tasks.OpenSeleniumHome;
import com.example.tasks.SearchFor;
import com.example.tasks.MaximizeBrowser;
import com.example.questions.PageTitle;
import com.example.questions.SearchResultsContain;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.core.steps.Instrumented;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Managed;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class WebStepDefinitions {

    @Managed
    WebDriver browser;

    private Actor actor;

    @Before("@AUTOMATION_WEB")
    public void setTheStage() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("QA_Automation");
        actor.can(BrowseTheWeb.with(browser));
        actor.attemptsTo(MaximizeBrowser.window());
    }

    @Dado("que un usuario abre la página de inicio")
    public void queUnUsuarioAbreLaPaginaDeInicio() {
        actor.attemptsTo(OpenSeleniumHome.onTheHomePage());
    }

    @Entonces("debería ver el título {string}")
    public void deberiaVerElTitulo(String expectedTitle) {
        String actual = PageTitle.value(actor);
        assertThat(actual, is(expectedTitle));
    }

    @Cuando("selecciona el apartado {string}")
    public void navegaAlApartado(String section) {
        actor.attemptsTo(NavigateToDocumentation.byLinkText(section));
    }

    @Entonces("la url de la pagina debería contener {string}")
    public void laUrlDeberiaContener(String fragment) {
        String current = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        assertThat(current, containsString(fragment));
    }

    @Cuando("realiza una búsqueda por {string}")
    public void realizaUnaBusquedaPor(String term) {
        actor.attemptsTo(SearchFor.term(term));
    }

    @Entonces("los resultados deberían contener {string}")
    public void losResultadosDeberianContener(String term) {
        boolean ok = SearchResultsContain.of(actor, term);
        assertThat(ok, is(true));
    }
}
