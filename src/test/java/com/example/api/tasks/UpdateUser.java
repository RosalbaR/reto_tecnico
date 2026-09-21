package com.example.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.HashMap;
import java.util.Map;

public class UpdateUser implements Task {

    private final int id;
    private final String name;
    private final String job;

    public UpdateUser(int id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("job", job);

        actor.attemptsTo(
                Put.to("/api/users/" + id)
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(payload))
        );
    }

    public static UpdateUser withIdAndPayload(int id, String name, String job) {
        return new UpdateUser(id, name, job);
    }
}
