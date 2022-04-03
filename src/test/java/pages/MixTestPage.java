package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;

public class MixTestPage {

    WebDriver driver;

    @FindBy(css = ".card span")
    List<WebElement> itemFields;


    public MixTestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkItemByItemValue(String itemValue) throws InterruptedException {
        boolean isItemExist = false;
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        for (int i = 0; i < 30; i++){
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(100);
        }

        for (WebElement item : itemFields) {
            if (item.getText().equals(itemValue)) {
                isItemExist = true;
                Assert.assertTrue(isItemExist);
                break;
            }
        }
        if (isItemExist == false) {
            Assert.assertTrue(isItemExist);
        }
    }
}