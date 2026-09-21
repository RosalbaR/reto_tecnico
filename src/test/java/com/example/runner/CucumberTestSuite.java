package com.example.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// Runner principal del proyecto.
// Su función es decirle a Cucumber + Serenity qué features cargar,
// qué package contiene los step definitions y cómo generar la ejecución.
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "com.example.stepdefinitions"
)
public class CucumberTestSuite {
    // La clase queda vacía porque el comportamiento principal se configura con las anotaciones.
    // Serenity usa esta clase como punto de entrada para ejecutar la suite.
}
