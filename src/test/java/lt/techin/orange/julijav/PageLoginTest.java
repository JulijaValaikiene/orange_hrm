package lt.techin.orange.julijav;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageLoginTest extends PageBaseTest {
    PageLogin pageLogin;
    PageAcount pageAcount;
//    String userName = "Admin";
//    String password = "admin123";
    String wrongUserName = " ";
    String wrongPassword = " ";
        @Test
    void loginTest(){
//        Wait<WebDriver> wait = new WebDriverWait(driver, ofSeconds(5));
//        WebElement userElement = driver.findElement(By.xpath("//input[@name='username']"));
//        WebElement passwordElement = driver.findElement(By.xpath("//input[@name='password']"));

            pageLogin = new PageLogin(driver);
            pageAcount = new PageAcount(driver);

        Assertions.assertEquals("Login",pageLogin.findLoginElement());
           String loginText = pageLogin.getUserNameFromText();
           pageLogin.enterUserName(loginText);
           String passwordText = pageLogin.getPasswordFromText();
           pageLogin.enterPassword(passwordText);
//        wait.until(d ->userElement.isDisplayed());
//            pageLogin.enterUserName(userName);
//        wait.until(d-> passwordElement.isDisplayed());
//            pageLogin.enterPassword(password);
            pageLogin.clickButton();
        Assertions.assertEquals("My Actions",pageAcount.findMyActionsElement());
    }
    @Test
    void wrongLoginUserNameTest(){
        pageLogin = new PageLogin(driver);
        pageAcount = new PageAcount(driver);
    Assertions.assertEquals("Login",pageLogin.findLoginElement());
        pageLogin.enterUserName(wrongUserName);
        String passwordText = pageLogin.getPasswordFromText();
        pageLogin.enterPassword(passwordText);
    Assertions.assertEquals("Required", pageLogin.getErrorRequiredMessage());
        pageLogin.clickButton();
    }
    @Test
    void wrongLoginPasswordTest(){
        pageLogin = new PageLogin(driver);
        pageAcount = new PageAcount(driver);
    Assertions.assertEquals("Login",pageLogin.findLoginElement());
        String loginText = pageLogin.getUserNameFromText();
        pageLogin.enterUserName(loginText);
        pageLogin.enterPassword(wrongPassword);
    Assertions.assertEquals("Required", pageLogin.getErrorRequiredMessage());
        pageLogin.clickButton();
    }
}
