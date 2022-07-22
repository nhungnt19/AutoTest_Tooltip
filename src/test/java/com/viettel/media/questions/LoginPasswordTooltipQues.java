package com.viettel.media.questions;

import com.viettel.media.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginPasswordTooltipQues implements Question {
    public static LoginPasswordTooltipQues theValue() {
        return new LoginPasswordTooltipQues();
    }

    @Override
    public Object answeredBy(Actor actor) {
        return LoginPage.PASSWORD_FIELD.resolveFor(actor).getAttribute("data-original-title");
    }
}
