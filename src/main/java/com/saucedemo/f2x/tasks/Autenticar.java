package com.saucedemo.f2x.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.model.util.EnvironmentVariables;

import static com.saucedemo.f2x.userinterface.Login.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Autenticar implements Task {

    private final String actorName;
    private EnvironmentVariables environmentVariables;
    public Autenticar(String actorName) {
        this.actorName = actorName;
    }

    public static Autenticar cloud(String actorName){
        return instrumented(Autenticar.class, actorName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String usernameKey = "users." + actorName + ".username";
        String passwordKey = "users." + actorName + ".password";
        // Lee el usuario y la contraseña desde serenity.conf
        String username = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(usernameKey);
        String password = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(passwordKey);

        actor.attemptsTo(

                Enter.keyValues(username).into(TXT_USERNAME),
                Enter.keyValues(password).into(TXT_PASSWORD),
                Click.on(BTN_LOGIN)

                );
        Serenity.takeScreenshot();

    }
}
