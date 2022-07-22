package com.viettel.media.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("http://testmaster.vn/admin")
public class LoginPage extends PageObject {

//    public static Target USERNAME_FIELD = Target.the("Username field")
//            .locatedBy("input[type=email]");
//
//    public static Target PASSWORD_FIELD = Target.the("Password field")
//            .locatedBy("input[type=password]");
//    public static Target LOGIN_BUTTON = Target.the("Login button")
//            .locatedBy("//button[text()=\"Đăng nhập\"]");

    public static final Target USERNAME_FIELD = Target.the("Username").located(By.cssSelector("input[type=email]")) ;
    public static final Target PASSWORD_FIELD = Target.the("Password").located(By.cssSelector("input[type=password]")) ;
    public static final Target LOGIN_BUTTON = Target.the("LoginButton").located(By.xpath("//button[text()=\"Đăng nhập\"]"));
}
