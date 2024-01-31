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
    @FindBy(xpath = "//div[contains(@class, 'orangehrm-demo-credentials')]/p[1]")
    WebElement partOfUsername;

    @FindBy(xpath = "//div[contains(@class, 'orangehrm-demo-credentials')]/p[2]")
    WebElement partOfPassword;
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement requiredMessage;


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
    public String getUserNameFromText(){

        return partOfUsername.getText().split(":")[1].trim();
    }
    public String getPasswordFromText(){

        return partOfPassword.getText().split(":")[1].trim();
    }
public String getErrorRequiredMessage(){

        return requiredMessage.getText();
}
}
