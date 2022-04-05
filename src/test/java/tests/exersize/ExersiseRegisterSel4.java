package tests.exersize;

import base.SeleniumBase;
import org.testng.annotations.Test;
import pages.RahulShettyTablePage;
import pages.TestExPage;
import utils.Utils;

import java.util.Map;

public class ExersiseRegisterSel4 extends SeleniumBase {

    RahulShettyTablePage rahulShettyTablePage;

    @Test
    public void table() {
        rahulShettyTablePage = new RahulShettyTablePage(driver);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        rahulShettyTablePage.table();
//        rahulShettyTablePage.browserWindow();
//        rahulShettyTablePage.browserTab();
        rahulShettyTablePage.doubleClick();





    }
}
