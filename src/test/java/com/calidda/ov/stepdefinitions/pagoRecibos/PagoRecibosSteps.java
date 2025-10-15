package com.calidda.ov.stepdefinitions.pagoRecibos;

import com.calidda.ov.tasks.pagarRecibo.ConsultarRecibo;
import com.calidda.ov.tasks.pagarRecibo.MenuPagoRecibo;
import com.calidda.ov.tasks.reclamoCliente.MenuReclamoCliente;
import io.cucumber.java.es.Cuando;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoRecibosSteps {


    @Cuando("el usuario selecciona menu pago recibos")
    public void elUsuarioSeleccionaMenuPagoRecibos() {
        theActorInTheSpotlight().wasAbleTo(
                MenuPagoRecibo.seleccionar()
        );
    }

    @Cuando("el usuario selecciona el numero de recibo para pago")
    public void elUsuarioSeleccionaElNumeroDeReciboParaPago(Map<String, String> NoRecibo) {
        theActorInTheSpotlight().wasAbleTo(
                ConsultarRecibo.pago(NoRecibo)
        );
    }
}
