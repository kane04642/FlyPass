package com.grupoemi.socloud.tasks.crearServicio;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.grupoemi.socloud.userinterface.CrearClientePOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InformacionGeografica implements Task {

    private final String ciudad,  barrio,  direccion;

    public InformacionGeografica(String ciudad, String barrio, String direccion) {
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.direccion = direccion;
    }

    public static InformacionGeografica deUsuario(String ciudad, String barrio, String direccion) {
        return instrumented(InformacionGeografica.class, ciudad,barrio, direccion );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(LIS_CIUDAD),
                Click.on(SLC_CIUDAD.of(ciudad)),
                Click.on(LIS_BARRIO),
                Click.on(SLC_BARRIO.of(barrio)),
                Enter.theValue(direccion).into(TXT_DIRRECCION)

        );
    }
}
