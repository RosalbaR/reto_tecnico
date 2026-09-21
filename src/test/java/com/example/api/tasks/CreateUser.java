package com.example.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

public class CreateUser implements Task {

    private final String name;
    private final String job;

    public CreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("job", job);

        actor.attemptsTo(
                Post.to("/api/users")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(payload))
        );
    }

    public static CreateUser withNameAndJob(String name, String job) {
        return new CreateUser(name, job);
    }
}
