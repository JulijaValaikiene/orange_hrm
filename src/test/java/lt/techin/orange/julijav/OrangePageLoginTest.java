package lt.techin.orange.julijav;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrangePageLoginTest  {
    WebDriver driver;
    String givenUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    String userName = "Admin";
    String password = "admin123";


//public static String main (String[] args){
//    String inputText = "Password : admin123";
//   String[] textArray = inputText.split(":");
//   for (String givenText: textArray) {
//       return textArray[1].trim();
//   }
//   return textArray[1];
//}

//    public static void main(String[] args) {
//        String inputText = "Password : admin123";
//        String password = extractPassword(inputText, ":");
//
//        if (password != null) {
//            System.out.println("Password: " + password);
//        } else {
//            System.out.println("Password not found in the input text.");
//        }
//    }
//    public static String extractPassword(String inputText, String delimiter) {
//        return Arrays.stream(inputText.split(delimiter))
//                .skip(1) // Skip the part before the delimiter
//                .findFirst() // Take the first element after the delimiter
//                .map(String::trim) // Trim the password
//                .orElse(null); // Return null if the password is not found
//    }
//
////    public static String extractPassword(String inputText) {
////        String[] textArray = inputText.split(":");
////        if (textArray.length > 1) {
////            return textArray[1].trim();
////        } else {
////            return null;
////        }


//    public static String extractPassword(String inputText, String delimiter) {
//        return Arrays.stream(inputText.split(delimiter))
//                .skip(1)
//                .findFirst()
//                .map(String::trim)
//                .orElse(null);
//    }

//    public static void stepWait() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//        }
//    }
    @BeforeEach

    void beforeEachTest() {
        driver = new ChromeDriver();
        driver.get(givenUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void loginTest(){
        Wait<WebDriver> wait = new WebDriverWait(driver, ofSeconds(5));

        WebElement userElement = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordElement = driver.findElement(By.xpath("//input[@name='password']"));
//        WebElement accountElement = driver.findElement(By.xpath("//p[text()='My Actions']"));

        Assertions.assertEquals(driver.getTitle(), "OrangeHRM");
        assertTrue(driver.findElement(By.xpath("//h5[.='Login']")).isDisplayed());
        wait.until(d ->userElement.isDisplayed());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
//        stepWait();
        wait.until(d-> passwordElement.isDisplayed());
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        //        stepWait();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        wait.until(d-> accountElement.isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[text()='My Actions']")).isDisplayed());
    }

    @Test
    void wrongLoginTest(){
        Wait<WebDriver> wait = new WebDriverWait(driver, ofSeconds(5));

        WebElement userElement = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordElement = driver.findElement(By.xpath("//input[@name='password']"));
//        WebElement accountElement = driver.findElement(By.xpath("//p[text()='My Actions']"));

        Assertions.assertEquals(driver.getTitle(), "OrangeHRM");
        assertTrue(driver.findElement(By.xpath("//h5[.='Login']")).isDisplayed());
        wait.until(d ->userElement.isDisplayed());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(" ");
        assertTrue(driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")).isDisplayed());
//        stepWait();
        wait.until(d-> passwordElement.isDisplayed());
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        //        stepWait();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

}
