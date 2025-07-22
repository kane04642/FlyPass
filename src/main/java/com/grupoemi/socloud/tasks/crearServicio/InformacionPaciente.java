package com.grupoemi.socloud.tasks.crearServicio;

import com.grupoemi.socloud.interactions.Esperar;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.grupoemi.socloud.userinterface.CrearClientePOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InformacionPaciente implements Task {

    private final String tipoSolicitante, tipoDocumento, numeroDocumento, telefono, celular, email, nombre, edad, tipoEdad, sexo, pais;

    public InformacionPaciente(String tipoSolicitante, String tipoDocumento, String numeroDocumento, String telefono, String celular, String email, String nombre, String edad, String tipoEdad, String sexo, String pais) {
        this.tipoSolicitante = tipoSolicitante;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.nombre = nombre;
        this.edad = edad;
        this.tipoEdad = tipoEdad;
        this.sexo = sexo;
        this.pais = pais;
    }

    public static InformacionPaciente crearIP(String tipoSolicitante, String tipoDocumento, String numeroDocumento, String telefono, String celular, String email, String nombre, String edad, String tipoEdad, String sexo, String pais){
        return instrumented(InformacionPaciente.class,tipoSolicitante, tipoDocumento, numeroDocumento, telefono, celular, email, nombre, edad, tipoEdad, sexo, pais);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(LST_TIPO_SOLICITANTE),
                Click.on(SLC_TIPO_SOLICITANTE.of(tipoSolicitante)),
                Click.on(LST_TIPO_DOCUMENTO),
                Click.on(SLC_TIPO_DOCUMENTO.of(tipoDocumento)),
                Enter.theValue(numeroDocumento).into(TXT_NO_DOCUMENTO),
                Enter.theValue(telefono).into(TXT_TELEFONO),
                new Esperar(7000),
                Enter.theValue(celular).into(TXT_CELULAR),
                Click.on(LNK_EMAIL),
                new Esperar(2000),
                Click.on(LNK_NO_EMAIL),
                Enter.theValue(nombre).into(TXT_NOMBRE),
                Enter.theValue(edad).into(TXT_EDAD),
                Click.on(LIS_TIPO_EDAD),
                Click.on(SLC_TIPO_EDAD.of(tipoEdad)),
                Click.on(LIS_SEXO),
                Click.on(LST_SEXO.of(sexo)),
                Click.on(LIS_PAIS),
                Click.on(SLC_PAIS.of(pais))

        );
        Serenity.takeScreenshot();
    }

}
