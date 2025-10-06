package com.calidda.ov.tasks.reclamoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.Map;

import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NuevaDireccion implements Task {
    private final Map<String, String> nuevaDireccion;

    public NuevaDireccion(Map<String, String> nuevaDireccion) {
        this.nuevaDireccion = nuevaDireccion;
    }
    public static NuevaDireccion reclamo(Map<String, String> nuevaDireccion){
        return instrumented(NuevaDireccion.class,nuevaDireccion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(CHK_OTRA_DIRE_NOTIFICA),
                Enter.theValue(nuevaDireccion.get("referencia")).into(TXT_OTRA_DIRE_NOTIFICA),
                Click.on(LIS_OTRO_DEP_NOTIFICA),
                Click.on(SLC_OTRO_DEP_NOTIFICA.of(nuevaDireccion.get("departamento"))),
                Click.on(LIS_OTRO_PRO_NOTIFICA),
                Click.on(SLC_OTRO_PRO_NOTIFICA.of(nuevaDireccion.get("provincia"))),
                Click.on(LIS_OTRO_DIS_NOTIFICA),
                Click.on(SLC_OTRO_DIS_NOTIFICA.of(nuevaDireccion.get("distrito"))),
                Scroll.to(TXT_REFERENCIA_NOTIFICA),
                Enter.theValue(nuevaDireccion.get("referencia")).into(TXT_REFERENCIA_NOTIFICA),
                Click.on(BTN_ENVIAR_NOTI)
        );
    }
}
