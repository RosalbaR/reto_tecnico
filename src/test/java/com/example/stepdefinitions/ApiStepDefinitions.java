package com.example.stepdefinitions;

import com.example.api.tasks.CreateUser;
import com.example.api.tasks.ListUsers;
import com.example.api.tasks.UpdateUser;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

// Step definitions para los escenarios de API.
// Esta clase hace la conexión entre el lenguaje Gherkin y las Tasks REST del patrón Screenplay.
public class ApiStepDefinitions {

    private Actor actor;

    // @Before prepara el escenario: crea el actor y le da la habilidad de invocar APIs HTTP.
    @Before
    public void prepare() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("API_User");
        actor.can(CallAnApi.at("https://reqres.in"));
    }

    @Dado("que se consulta la lista de usuarios de la página {int}")
    public void queSeConsultaLaListaDeUsuariosDeLaPagina(int page) {
        actor.attemptsTo(ListUsers.page(page));
    }

    @Entonces("la respuesta tendrá estado {int} y contendrá {string}")
    public void laRespuestaTendraEstadoYContendra(int status, String key) {
        // Validación general de status + presencia de una clave en el body.
        SerenityRest.then().statusCode(status);
        String body = SerenityRest.lastResponse().getBody().asString();
        assertThat(body, containsString(key));
    }

    @Dado("que se crea un usuario con nombre {string} y trabajo {string}")
    public void queSeCreaUnUsuarioConNombreYTrabajo(String name, String job) {
        // Envía un POST para crear un usuario con nombre y trabajo.
        actor.attemptsTo(CreateUser.withNameAndJob(name, job));
    }

    @Dado("que se actualiza el usuario {int} con nombre {string} y trabajo {string}")
    public void queSeActualizaElUsuarioConNombreYTrabajo(int id, String name, String job) {
        // Envía un PUT para actualizar un usuario existente.
        actor.attemptsTo(UpdateUser.withIdAndPayload(id, name, job));
    }

    @Entonces("la respuesta tendrá estado {int} y contendrá el nombre {string}")
    public void laRespuestaTendraEstadoYContendraElNombre(int status, String name) {
        SerenityRest.then().statusCode(status);
        String body = SerenityRest.lastResponse().getBody().asString();
        assertThat(body, containsString(name));
    }

    @Entonces("la respuesta tendrá estado {int} y contendrá el trabajo {string}")
    public void laRespuestaTendraEstadoYContendraElTrabajo(int status, String job) {
        SerenityRest.then().statusCode(status);
        String body = SerenityRest.lastResponse().getBody().asString();
        assertThat(body, containsString(job));
    }
}
