package com.saucedemo.f2x.tasks;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private EnvironmentVariables environmentVariables;
    String urlBase;

    public static Login cloud(){
        return instrumented(Login.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        urlBase = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url");
        actor.attemptsTo(
                Open.url(urlBase)
        );
    }
}
