package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TraductorPage {

    private static WebDriver driver;

    public TraductorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='tl-sugg']//div[@id='sugg-item-en']")
    private WebElement button;

    @FindBy(id = "source")
    private WebElement write_Word;

    @FindBy(xpath = "//div[@class='result-shield-container tlid-copy-target']")
    private WebElement traslate_word;


    public void EnterWord(String word_Spanish) {
        write_Word.sendKeys(word_Spanish);
        button.click();
    }

    public String Comparetranslation() {
        return traslate_word.getText();
    }

}
