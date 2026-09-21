package com.example.api.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.json.JSONObject;

// Task que crea un nuevo usuario mediante el endpoint POST /api/users.
// Se usa para validar la creación de recursos y la estructura de la respuesta.
public class CreateUser implements Task {

    private final String name;
    private final String job;

    // Constructor con nombre y trabajo del usuario a crear.
    public CreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    // performAs arma el JSON y ejecuta la petición HTTP de creación.
    @Override
    public <T extends Actor> void performAs(T actor) {
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("job", job);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(payload.toString())
                .when()
                .post("/api/users")
                .then();
    }

    // Factory method para una lectura más clara en Gherkin/step definitions.
    public static CreateUser withNameAndJob(String name, String job) {
        return new CreateUser(name, job);
    }
}
