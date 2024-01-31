package lt.techin.orange.julijav;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class PageBaseTest {
  protected WebDriver driver;
  String givenUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
  @BeforeEach
    void setup(){
   driver= new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   driver.get(givenUrl);
  }
  @AfterEach
    void tearDown(){
      driver.quit();
  }
//    public static void stepWait() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//        }
//    }
}
