package com.grupoemi.socloud.interactions;

import net.serenitybdd.model.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Esperar implements Interaction {

    private int tiempo;
    public Esperar (int tiempo) {
        this.tiempo = tiempo;

    }

    public static Esperar unTiempo(int tiempo){
        return instrumented(Esperar.class, tiempo);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(tiempo);
    }
}
