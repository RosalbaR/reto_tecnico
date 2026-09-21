package com.example.api.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

// Task que consume el endpoint de listado de usuarios de ReqRes.
// Su finalidad es validar que la API responde correctamente con datos paginados.
public class ListUsers implements Task {

    private final int page;

    // Constructor que recibe la página a consultar.
    public ListUsers(int page) {
        this.page = page;
    }

    // performAs ejecuta la petición GET /api/users?page={page}.
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given()
                .queryParam("page", page)
                .when()
                .get("/api/users")
                .then();
    }

    // Factory method para crear la Task con legibilidad.
    public static ListUsers page(int page) {
        return new ListUsers(page);
    }
}
