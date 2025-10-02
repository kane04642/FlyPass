package com.calidda.ov.tasks.reclamoNoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static com.calidda.ov.userinterface.reclamoNoCliente.ReclamosNoClientePOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DireccionOcurrencia implements Task {

    private final Map<String, String> direccionOcurrencia;

    public DireccionOcurrencia(Map<String, String> direccionOcurrencia) {
        this.direccionOcurrencia = direccionOcurrencia;
    }
    public static DireccionOcurrencia delReclamo(Map<String, String> direccionOcurrencia){
        return instrumented(DireccionOcurrencia.class,direccionOcurrencia);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LIS_TIPO_CALLE),
                Click.on(SLC_TIPO_CALLE.of(direccionOcurrencia.get("tipoCalle"))),
                Enter.theValue(direccionOcurrencia.get("nombreCalle")).into(TXT_NOM_CALLE),
                Enter.theValue(direccionOcurrencia.get("Nro")).into(TXT_NRO_CALLE),
                Click.on(LIS_TIPO_EDIFICIO),
                Click.on(SLC_TIPO_EDIFICIO.of(direccionOcurrencia.get("tipoEdificio"))),
                Enter.theValue(direccionOcurrencia.get("edificio")).into(TXT_EDIFICIO),
                Click.on(LIS_TIPO_VIVIENDA),
                Click.on(SLC_TIPO_VIVIENDA.of(direccionOcurrencia.get("tipoVivienda"))),
                Enter.theValue(direccionOcurrencia.get("nombreVivienda")).into(TXT_NOM_VIVIENDA),
                Enter.theValue(direccionOcurrencia.get("piso")).into(TXT_PISO),
                Click.on(LIS_TIPO_INTERIOR),
                Click.on(SLC_TIPO_INTERIOR.of(direccionOcurrencia.get("tipoInterior"))),
                Enter.theValue(direccionOcurrencia.get("interior")).into(TXT_INTERIOR),
                Click.on(LIS_TIPO_COMITE),
                Click.on(SLC_TIPO_COMITE.of(direccionOcurrencia.get("tipoComite"))),
                Enter.theValue(direccionOcurrencia.get("nombreComite")).into(TXT_COMITE),
                Enter.theValue(direccionOcurrencia.get("Mz")).into(TXT_MZ),
                Enter.theValue(direccionOcurrencia.get("Lt")).into(TXT_LT),
                Click.on(LIS_TIPO_CONJUNTO),
                Click.on(SLC_TIPO_CONJUNTO.of(direccionOcurrencia.get("tipoConVivienda"))),
                Enter.theValue(direccionOcurrencia.get("nombreConVivienda")).into(TXT_NOM_CONJUNTO),
                Click.on(LIS_DEPARTAMENTO),
                Click.on(SLC_DEPARTAMENTO.of(direccionOcurrencia.get("departamento"))),
                Click.on(LIS_TIPO_PROVINCIA),
                Click.on(SLC_TIPO_PROVINCIA.of(direccionOcurrencia.get("provincia"))),
                Click.on(LIS_TIPO_DISTRITO),
                Click.on(SLC_TIPO_DISTRITO.of(direccionOcurrencia.get("distrito")))

        );

    }
}
