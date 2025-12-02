package com.davivienda.orange.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import static com.davivienda.orange.userinterface.Login.*;

public class HomePageVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.the(LBL_SALUD_OV).answeredBy(actor).isCurrentlyVisible();
    }

    public static HomePageVisible isVisible() {
        return new HomePageVisible();
    }
}
