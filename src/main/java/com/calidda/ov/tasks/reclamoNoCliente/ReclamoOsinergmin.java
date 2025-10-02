package com.calidda.ov.tasks.reclamoNoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.Map;

import static com.calidda.ov.userinterface.reclamoNoCliente.ReclamosNoClientePOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ReclamoOsinergmin implements Task {

    private final Map<String, String> tipoOsinergmin;

    public ReclamoOsinergmin(Map<String, String> tipoOsinergmin) {
        this.tipoOsinergmin = tipoOsinergmin;
    }

    public static ReclamoOsinergmin nocliente(Map<String, String> tipoOsinergmin){
        return instrumented(ReclamoOsinergmin.class, tipoOsinergmin);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_OSINERGMIN),
                Scroll.to(LIS_MOTIVO_OSINERGMIN),
                Click.on(LIS_MOTIVO_OSINERGMIN),
                Click.on(SLC_MOTIVO_OSINERGMIN.of(tipoOsinergmin.get("motivo"))),
                Click.on(LIS_SUBMOTIVO_OSINERGMIN),
                Click.on(SLC_SUBMOTIVO_OSINERGMIN.of(tipoOsinergmin.get("submotivo"))),
                Enter.theValue(tipoOsinergmin.get("descripcionReclamo")).into(TXT_DESCRIPCION_RECLAMO),
                Click.on(CHK_POLI_PRIVACIDAD)

        );
    }
}
