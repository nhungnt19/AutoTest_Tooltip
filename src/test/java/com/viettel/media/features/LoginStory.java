package com.viettel.media.features;

import com.viettel.media.questions.LoginPasswordTooltipQues;
import com.viettel.media.questions.LoginUsernameTooltipQues;
import com.viettel.media.questions.TheListQuesion;
import com.viettel.media.tasks.LoginTask;
import com.viettel.media.ui.LoginPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SerenityRunner.class)
public class LoginStory {
    @Managed
    WebDriver annaBrowser;
    Actor anna = Actor.named("Anna");

    LoginPage loginPage;

    @Before
    public void init(){
        anna.can(BrowseTheWeb.with(annaBrowser));

    }

    @Test
    public void Should_see_tooltip_with_blank_username(){
        //preCond
        anna.wasAbleTo(Open.browserOn(loginPage));
        String username = "";
        String password = "123456@a@";
        String usernameTooltip = "Hãy nhập E-mail ở định dạng: user@email.com";
        //behavior
        anna.attemptsTo(
                LoginTask.withUsername(username).andPassword(password)
        );
        //verify
        anna.should(
                seeThat(LoginUsernameTooltipQues.theValue(), equalTo(usernameTooltip))
        );
    }
    @Test
    public void Should_see_tooltip_with_blank_password(){
        //preCond
        anna.wasAbleTo(Open.browserOn(loginPage));
        String username = "nhungnt@viettel.com.vn";
        String password = "";
        String pwdTooltip = "Mật khẩu chỉ nhận giá trị chữ và số";
        //behavior
        anna.attemptsTo(
                LoginTask.withUsername(username).andPassword(password)
        );
        //verify
        anna.should(
                seeThat(LoginPasswordTooltipQues.theValue(), equalTo(pwdTooltip))
        );
    }

    @Test
    public void Should_see_tooltip_with_blank_username_and_blank_password(){
        //preCond
        anna.wasAbleTo(Open.browserOn(loginPage));
        String username = "";
        String password = "";
        String usernameTooltip = "Hãy nhập E-mail ở định dạng: user@email.com";
        String pwdTooltip = "Mật khẩu chỉ nhận giá trị chữ và số";
        //behavior
        anna.attemptsTo(
                LoginTask.withUsername(username).andPassword(password)
        );
        //verify
        anna.should(
//                seeThat(LoginUsernameTooltipQues.theValue(), equalTo(usernameTooltip)),
//                seeThat(LoginPasswordTooltipQues.theValue(), equalTo(pwdTooltip))
                seeThat(TheListQuesion.loginUsernameTooltipQues.theValue(), equalTo(usernameTooltip)),
                seeThat(TheListQuesion.loginPasswordTooltipQues.theValue(), equalTo(pwdTooltip))

        );
    }
}
