package lt.techin.orange.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLogin extends PageBase {

    @FindBy(xpath ="//input[@name='username']")
    WebElement userNameInput;
    @FindBy(xpath ="//input[@name='password']")
    WebElement passwordInput;
    @FindBy(xpath ="//button[@type='submit']")
    WebElement button;

    @FindBy(xpath = "//h5[.='Login']" )
    WebElement loginText;

    public PageLogin(WebDriver driver) {

        super (driver);
    }
    public void enterUserName(String userName){

        userNameInput.sendKeys(userName);
    }
    public void enterPassword(String password){

        passwordInput.sendKeys(password);
    }
    public void clickButton(){

        button.click();
    }
    public String findLoginElement(){

        return loginText.getText();
    }
}
