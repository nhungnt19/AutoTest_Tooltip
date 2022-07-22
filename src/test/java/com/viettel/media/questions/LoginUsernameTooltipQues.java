package com.viettel.media.questions;

import com.viettel.media.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginUsernameTooltipQues implements Question{

    public static LoginUsernameTooltipQues theValue() {
        return new LoginUsernameTooltipQues();
    }

    @Override
    public Object answeredBy(Actor actor) {
        String rs = LoginPage.USERNAME_FIELD.resolveFor(actor).getAttribute("data-original-title");
        return rs;

    }
}
