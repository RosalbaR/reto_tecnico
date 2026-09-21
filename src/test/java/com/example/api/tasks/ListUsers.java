package com.example.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ListUsers implements Task {

    private final int page;

    public ListUsers(int page) {
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users")
                        .with(request -> request.queryParam("page", page))
        );
    }

    public static ListUsers page(int page) {
        return new ListUsers(page);
    }
}
