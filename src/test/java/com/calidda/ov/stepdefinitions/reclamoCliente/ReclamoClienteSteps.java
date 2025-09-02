package com.calidda.ov.stepdefinitions.reclamoCliente;

import com.calidda.ov.tasks.AutenticarOV;
import com.calidda.ov.tasks.LoginOV;
import com.calidda.ov.tasks.reclamoCliente.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReclamoClienteSteps {
    @Dado("el usuario selecciona ingreso reclamos")
    public void elUsuarioSeleccionaIngresoReclamos() {
        theActorInTheSpotlight().wasAbleTo(
                MenuReclamoCliente.operaciones()
        );
    }



    @Cuando("el usuario ingresa las credenciales para autenticacion")
    public void elUsuarioIngresaLasCredencialesParaAutenticacion(Map<String, String> datosReclamosCliente) {

        theActorInTheSpotlight().wasAbleTo(
                AutenticarOV.cloud(datosReclamosCliente.get("actor"))
        );
    }

    @Cuando("el usuario ingresa los datos del reclamante")
    public void elUsuarioIngresaLosDatosDelReclamante(Map<String, String> datosReclamosCliente) {
        theActorInTheSpotlight().wasAbleTo(
                DatosReclamante.cliente(datosReclamosCliente.get("numeroCliente"))
        );
    }

    @Cuando("el usuario ingresa datos del representante")
    public void elUsuarioIngresaDatosDelRepresentante(Map<String, String> datosReclamosCliente) {
        theActorInTheSpotlight().wasAbleTo(
                DatosRepresentante.legal(datosReclamosCliente)
        );
    }

    @Cuando("el usuario ingresa datos de motivo de reclamo")
    public void elUsuarioIngresaDatosDeMotivoDeReclamo(Map<String, String> datosMotivo) {
        theActorInTheSpotlight().wasAbleTo(
                MotivoReclamo.cliente(datosMotivo)
        );
    }

    @Cuando("el usuario ingresa datos notificacion")
    public void elUsuarioIngresaDatosNotificacion(Map<String, String> emailT) {
        theActorInTheSpotlight().wasAbleTo(
                NotificacionReclamo.email(emailT)
        );
    }
}
