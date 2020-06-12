import PageObject.TraductorPage;
import com.thoughtworks.gauge.*;
import jdk.nashorn.internal.runtime.Context;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepImplementation {

    private static WebDriver driver;

    @BeforeSpec
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Step("User enters the page <https://translate.google.com/?hl=es>")
    public void implementation1(String url) {
        driver.get(url);
    }

    @Step("He enters the world <Hola>")
    public void implementation2(String word) {
        TraductorPage a = new TraductorPage(driver);
        a.EnterWord(word);

    }

    @Step("he should see the Successful translation <Hello>")
    public void implementation3(String translation) {
        TraductorPage b = new TraductorPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS).pageLoadTimeout(10, TimeUnit.SECONDS);
        String text = b.Comparetranslation();
        Assert.assertEquals(text, translation);
    }

    @AfterSpec
    public void Close() {
        driver.close();
    }
}
