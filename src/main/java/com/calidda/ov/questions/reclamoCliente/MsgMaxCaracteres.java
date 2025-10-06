package com.calidda.ov.questions.reclamoCliente;

import com.calidda.ov.questions.registro.CamposObligatorios;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.MSG_MAX_CARACTERES;

public class MsgMaxCaracteres implements Question<String> {

    public static Question<String> value(){
        return new MsgMaxCaracteres();
    }
    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(MSG_MAX_CARACTERES).getText();

    }
}
