package com.example.api.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.json.JSONObject;

// Task que actualiza un usuario existente a través de PUT /api/users/{id}.
// Sirve para verificar que la API procesa cambios de datos correctamente.
public class UpdateUser implements Task {

    private final int id;
    private final String name;
    private final String job;

    // Constructor con id, nombre y nuevo trabajo del usuario a actualizar.
    public UpdateUser(int id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    // performAs genera el JSON y realiza la actualización del recurso.
    @Override
    public <T extends Actor> void performAs(T actor) {
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("job", job);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(payload.toString())
                .when()
                .put("/api/users/" + id)
                .then();
    }

    // Factory method para mantener legibilidad y reutilización.
    public static UpdateUser withIdAndPayload(int id, String name, String job) {
        return new UpdateUser(id, name, job);
    }
}
