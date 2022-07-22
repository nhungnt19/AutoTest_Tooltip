package com.viettel.media.tasks;

import com.viettel.media.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task {

    private String username;
    private String password;

    public LoginTask(String username, String password){
        this.username = username;
        this.password = password;
    }

    public static LoginTaskBuilder withUsername(String username) {
        return new LoginTaskBuilder(username);
    }

    public static class LoginTaskBuilder{
        private String username;
        private String password;
        public LoginTaskBuilder(String username){
            this.username = username;
        }


        public Performable andPassword(String password) {
            this.password = password;
            return instrumented(LoginTask.class,this.username,this.password);
        }
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.username).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(this.password).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );

    }
}
