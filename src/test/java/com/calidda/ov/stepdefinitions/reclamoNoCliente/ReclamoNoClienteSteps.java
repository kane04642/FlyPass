package com.calidda.ov.stepdefinitions.reclamoNoCliente;

import com.calidda.ov.tasks.reclamoCliente.DatosRepresentante;
import com.calidda.ov.tasks.reclamoNoCliente.*;
import io.cucumber.java.es.Cuando;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReclamoNoClienteSteps {

    @Cuando("el usuario ingresa al menu de reclamos no clientes")
    public void elUsuarioIngresaAlMenuDeReclamosNoClientes() {
        theActorInTheSpotlight().wasAbleTo(
                OpenUrlNoCliente.paraNoCliente()
        );
    }

    @Cuando("el usuario ingresa los datos del reclamante no cliente")
    public void elUsuarioIngresaLosDatosDelReclamanteNoCliente(Map<String, String> datosReclamanteNoCliente) {
        theActorInTheSpotlight().wasAbleTo(
                DatosReclamanteNoCliente.ingresa(datosReclamanteNoCliente)
        );
    }

    @Cuando("el usuario ingresa datos de direccion de ocurrencia")
    public void elUsuarioIngresaDatosDeDireccionDeOcurrencia(Map<String, String> direccionOcurrencia) {
        theActorInTheSpotlight().wasAbleTo(
                DireccionOcurrencia.delReclamo(direccionOcurrencia)
        );
    }

    @Cuando("el usuario selecciona reclamo OSINERGMIN")
    public void elUsuarioSeleccionaReclamoOSINERGMIN(Map<String, String> tipoOsinergmin) {
        theActorInTheSpotlight().wasAbleTo(
                ReclamoOsinergmin.nocliente(tipoOsinergmin)
        );
    }

    @Cuando("el usuario selecciona identificacion del bien contratado")
    public void elUsuarioSeleccionaIdentificacionDelBienContratado(Map<String, String> tipoBien) {
        theActorInTheSpotlight().wasAbleTo(
                BienContratado.tipo(tipoBien)
        );
    }

    @Cuando("el usuario da click en guardar")
    public void elUsuarioDaClickEnGuardar() {
        theActorInTheSpotlight().wasAbleTo(
                GuardarReclamo.noCliente()
        );
    }
}
