package com.saucedemo.f2x.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import static com.saucedemo.f2x.userinterface.Login.LBL_PAGE;

public class HomePageVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.the(LBL_PAGE).answeredBy(actor).isCurrentlyVisible();
    }

    public static HomePageVisible isVisible() {
        return new HomePageVisible();
    }
}
