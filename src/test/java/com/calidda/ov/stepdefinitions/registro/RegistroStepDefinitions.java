package com.calidda.ov.stepdefinitions.registro;

import com.calidda.ov.constantes.Constantes;
import com.calidda.ov.questions.registro.CamposObligatorios;
import com.calidda.ov.questions.registro.RegistroNoRecibo;
import com.calidda.ov.tasks.registro.CancelarRegistro;
import com.calidda.ov.tasks.registro.RegistrarCliente;
import com.calidda.ov.tasks.registro.RegistrarEmpresa;
import com.calidda.ov.tasks.registro.SeleccionarEmpresa;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Performable;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class RegistroStepDefinitions {

    @Cuando("el usuario ingresa datos del registro")
    public void elUsuarioIngresaDatosDelRegistro(Map<String, String> registroCliente) {
        theActorInTheSpotlight().wasAbleTo(
                RegistrarCliente.nuevoUsuario(registroCliente)
        );
    }

    @Entonces("el usuario valida boton de error en recibo no valido")
    public void elUsuarioValidaBotonDeErrorEnReciboNoValido() {
        theActorInTheSpotlight().should(
                seeThat(RegistroNoRecibo.isVisible())
        );
    }

    @Entonces("el usuario valida mensaje de campos obligatorios")
    public void elUsuarioValidaMensajeDeCamposObligatorios() {
        theActorInTheSpotlight().should(
                seeThat("Se genera mensaje de campos obligatorios", CamposObligatorios.value(),equalTo(Constantes.MSG_CAMPOS_OBLIGATORIOS))

        );
    }

    @Entonces("el usuario valida mensaje de registro exitoso")
    public void elUsuarioValidaMensajeDeRegistroExitoso() {
        
    }

    @Cuando("el usuario da click en cancelar registro")
    public void elUsuarioDaClickEnCancelarRegistro() {
        theActorInTheSpotlight().attemptsTo(
                CancelarRegistro.newUsuario()
        );
    }

    @Entonces("el usuario valida mensaje cancelar")
    public void elUsuarioValidaMensajeCancelar() {
        theActorInTheSpotlight().should(
                seeThat("Se genera mensaje de confirmar cancelar registro", com.calidda.ov.questions.registro.CancelarRegistro.value(),equalTo(Constantes.MSG_CANCELAR_REGISTRO))

        );
    }

    @Dado("el usuario da click en pestaña de empresa")
    public void elUsuarioDaClickEnPestanaDeEmpresa() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarEmpresa.nueva()
        );
    }

    @Cuando("el usuario ingresa datos del registro de empresa")
    public void elUsuarioIngresaDatosDelRegistroDeEmpresa(Map<String, String> datosEmpresa) {
        theActorInTheSpotlight().attemptsTo(
                RegistrarEmpresa.nueva(datosEmpresa)
        );
    }

    @Entonces("el usuario valida mensaje exitoso de creacion")
    public void elUsuarioValidaMensajeExitosoDeCreacion() {
    }
}
