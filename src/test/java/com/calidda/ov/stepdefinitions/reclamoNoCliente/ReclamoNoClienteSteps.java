package com.calidda.ov.stepdefinitions.reclamoNoCliente;

import com.calidda.ov.tasks.reclamoCliente.DatosRepresentante;
import com.calidda.ov.tasks.reclamoNoCliente.DatosReclamanteNoCliente;
import com.calidda.ov.tasks.reclamoNoCliente.OpenUrlNoCliente;
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
}
