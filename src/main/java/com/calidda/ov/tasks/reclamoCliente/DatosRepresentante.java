package com.calidda.ov.tasks.reclamoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DatosRepresentante implements Task {

    private final Map<String, String> datosReclamosCliente;

    public DatosRepresentante(Map<String, String> datosReclamosCliente) {
        this.datosReclamosCliente = datosReclamosCliente;
    }

    public static DatosRepresentante legal(Map<String, String> datosReclamosCliente){
        return instrumented(DatosRepresentante.class, datosReclamosCliente);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CHK_DATOS_REPRESENTANTE),
                Click.on(LIS_TIPO_RELACION),
                Click.on(SLC_TIPO_RELACION.of(datosReclamosCliente.get("tipoRelacion"))),
                Enter.theValue(datosReclamosCliente.get("nombreRepre")).into(TXT_NOMBRE_REPRE),
                Enter.theValue(datosReclamosCliente.get("apellidoRepre")).into(TXT_APELLIDO_REPRE),
                Click.on(LIS_TIPO_DOCU_REPRE),
                Click.on(SLC_TIPO_DOCU_REPRE.of(datosReclamosCliente.get("tipoDocumenRepre"))),
                Enter.theValue(datosReclamosCliente.get("numeroDocumenRepre")).into(TXT_NUM_DOCU_REPRE),
                Enter.theValue(datosReclamosCliente.get("telefonoFijoRepre")).into(TXT_TELE_FIJO_REPRE),
                Enter.theValue(datosReclamosCliente.get("celularRepre")).into(TXT_CELU_REPRE),
                Enter.theValue(datosReclamosCliente.get("emailRepre")).into(TXT_EMAIL_REPRE),
                Click.on(BTN_SIGUIENTE_REPRE)
        );
    }
}
