package com.calidda.ov.questions.registro;

import com.calidda.ov.questions.HomePageVisible;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static com.calidda.ov.userinterface.Login.BTN_ERROR_REGISTRO;

public class RegistroNoRecibo implements Question<Boolean> {
    public static RegistroNoRecibo isVisible() {
        return new RegistroNoRecibo();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.the(BTN_ERROR_REGISTRO).answeredBy(actor).isCurrentlyVisible();

    }
}
