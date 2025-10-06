package com.calidda.ov.questions.reclamoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.BTN_SIGUi_RECLAMANTE;


public class CheckPoliPrivaObligatorio implements Question<Boolean> {

    public static CheckPoliPrivaObligatorio isNotPresent() {
        return new CheckPoliPrivaObligatorio();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.the(BTN_SIGUi_RECLAMANTE).answeredBy(actor).isCurrentlyVisible();
    }
}
