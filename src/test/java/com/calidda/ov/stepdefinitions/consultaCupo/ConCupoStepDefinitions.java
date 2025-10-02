package com.calidda.ov.stepdefinitions.consultaCupo;

import com.calidda.ov.tasks.consultaCupo.ConsultaCupo;
import io.cucumber.java.es.Cuando;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConCupoStepDefinitions {
    @Cuando("el usuario seleciona consultar mi linea de credito")
    public void elUsuarioSelecionaConsultarMiLineaDeCredito() {
        theActorInTheSpotlight().wasAbleTo(
                ConsultaCupo.credito()
        );
    }
}
