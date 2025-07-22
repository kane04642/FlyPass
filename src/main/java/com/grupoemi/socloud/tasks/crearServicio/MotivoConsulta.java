package com.grupoemi.socloud.tasks.crearServicio;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static com.grupoemi.socloud.userinterface.CrearClientePOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MotivoConsulta implements Task {

    private final String motivo,  cuadroClinico;

    public MotivoConsulta(String motivo, String cuadroClinico) {
        this.motivo = motivo;
        this.cuadroClinico = cuadroClinico;
    }

    public static MotivoConsulta motivo(String motivo, String cuadroClinico){
        return instrumented(MotivoConsulta.class, motivo, cuadroClinico);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(motivo).into(TXT_MOTIVO),
                Enter.theValue(cuadroClinico).into(TXT_CUADRO_CLINICO)
        );
    }
}
