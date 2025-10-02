package com.calidda.ov.questions.registro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static com.calidda.ov.userinterface.Login.LNK_CAMPOS_OBLIGA;

public class CamposObligatorios implements Question<String> {

    public static Question<String> value(){
        return new CamposObligatorios();
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(LNK_CAMPOS_OBLIGA).getText();

    }
}
