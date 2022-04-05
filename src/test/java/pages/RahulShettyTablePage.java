package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class RahulShettyTablePage {

    WebDriver driver;

    public RahulShettyTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void table(){
        WebElement el = driver.findElement
                (By.cssSelector("[class='jumbotron text-center header_style']"));
        WebElement hover = driver.findElement(with(By.tagName("div")).
                below(By.cssSelector("[class='right-align']")).below(el));
        System.out.println(hover.getText() + "--------------");
    }

    public void browserWindow(){
        driver.get("https://www.google.com/");
        // Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Opens BrowserStack homepage in the newly opened window
        driver.navigate().to("https://www.browserstack.com/");

    }

    public void browserTab(){
        driver.get("https://www.google.com/");
        // Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.TAB);

        // Opens BrowserStack homepage in the newly opened window
        driver.navigate().to("https://www.browserstack.com/");

    }

    public void doubleClick(){
        driver.get("https://www.amazon.in/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
        Actions action = new Actions(driver);
        action.doubleClick(element).build().perform();
    }

}
