package com.calidda.ov.tasks.reclamoNoCliente;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenUrlNoCliente implements Task {

    private EnvironmentVariables environmentVariables;

    public static OpenUrlNoCliente paraNoCliente() {
        return instrumented(OpenUrlNoCliente.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String urlBase = environmentVariables.getProperty("environments.noCliente.webdriver.base.url");

        actor.attemptsTo(
                Open.url(urlBase)
        );
    }
}