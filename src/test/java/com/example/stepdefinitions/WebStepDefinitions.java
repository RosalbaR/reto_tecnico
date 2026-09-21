package com.example.stepdefinitions;

import com.example.tasks.NavigateToDocumentation;
import com.example.tasks.OpenSeleniumHome;
import com.example.tasks.SearchFor;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

// Step definitions para los escenarios web.
// Esta clase conecta el lenguaje Gherkin (features) con las Tasks y Questions del patrón Screenplay.
public class WebStepDefinitions {

    // WebDriver administrado por Serenity para cada escenario del navegador.
    @Managed
    WebDriver browser;

    // El actor representa al usuario que ejecuta las acciones de la prueba.
    private Actor actor;

    // @Before prepara el escenario antes de cada ejecución.
    // Aquí se crea el actor y se le asigna la habilidad de navegar por la web.
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("QA_Automation");
        actor.can(BrowseTheWeb.with(browser));
    }

    @Dado("que un usuario abre la página de inicio")
    public void queUnUsuarioAbreLaPaginaDeInicio() {
        // La tarea abre la URL principal de selenium.dev.
        actor.attemptsTo(OpenSeleniumHome.onTheHomePage());
    }

    @Entonces("debería ver el título {string}")
    public void deberiaVerElTitulo(String expectedTitle) {
        // La Question consulta el título actual y se compara con el valor esperado.
        String actual = PageTitle.value(actor);
        assertThat(actual, is(expectedTitle));
    }

    @Cuando("selecciona el apartado {string}")
    public void navegaAlApartado(String section) {
        // Se ejecuta la navegación al enlace indicado.
        actor.attemptsTo(NavigateToDocumentation.byLinkText(section));
    }

    @Entonces("la url de la pagina debería contener {string}")
    public void laUrlDeberiaContener(String fragment) {
        // Se valida que la URL del navegador contenga la ruta esperada.
        String current = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        assertThat(current, containsString(fragment));
    }

    @Cuando("realiza una búsqueda por {string}")
    public void realizaUnaBusquedaPor(String term) {
        // La búsqueda se ejecuta escribiendo el texto y enviando ENTER.
        actor.attemptsTo(SearchFor.term(term));
    }

    @Entonces("los resultados deberían contener {string}")
    public void losResultadosDeberianContener(String term) {
        // La Question verifica si el contenido de la página incluye el término buscado.
        boolean ok = SearchResultsContain.of(actor, term);
        assertThat(ok, is(true));
    }
}
