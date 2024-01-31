package lt.techin.orange.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class PageAcount extends PageBase {
    @FindBy (xpath = "//p[text()='My Actions']")
    WebElement actionElement;

    public PageAcount(WebDriver driver) {
        super(driver);
    }
    public String findMyActionsElement(){
        return actionElement.getText();
    }
}
