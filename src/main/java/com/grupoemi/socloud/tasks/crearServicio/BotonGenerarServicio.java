package com.grupoemi.socloud.tasks.crearServicio;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.grupoemi.socloud.userinterface.CrearClientePOM.BTN_ENVIAR_SERVICIO;
import static com.grupoemi.socloud.userinterface.CrearClientePOM.BTN_GENERAR_SERVICIO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BotonGenerarServicio implements Task {

    public static BotonGenerarServicio asServicio(){
        return instrumented(BotonGenerarServicio.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_GENERAR_SERVICIO),
                Click.on(BTN_ENVIAR_SERVICIO)
        );
    }
}
