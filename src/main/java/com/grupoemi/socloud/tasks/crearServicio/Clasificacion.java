package com.grupoemi.socloud.tasks.crearServicio;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static com.grupoemi.socloud.userinterface.CrearClientePOM.TXT_CLASIFICACION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Clasificacion implements Task {

    private final String clasificacion;

    public Clasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public static Clasificacion casifica(String clasificacion){
        return instrumented(Clasificacion.class, clasificacion);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(clasificacion).into(TXT_CLASIFICACION)
        );
    }
}
