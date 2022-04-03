package tests.exersize;

import base.ApiBase;
import base.SeleniumBase;
import io.restassured.response.Response;
import models.CreateItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pages.MixTestPage;
import utils.CustomLogger;

import java.util.ArrayList;
import java.util.List;

public class MixTest extends SeleniumBase {

    ApiBase apiBase = new ApiBase();
    String baseUrl = "https://restool-sample-app.herokuapp.com";
    List<String> headers = new ArrayList<>();
    String itemId;

    private String thumbnail = "GEVORGGevya@mail.com";
    private String name = "GG";
    private String realName = "Gevorg";
    private String location = "Beyond the Wall";
    private Boolean isAlive = true;

    private static final Logger log = LogManager.getLogger(MixTest.class.getName());

    @BeforeMethod
    public void addItemInList(){
        CreateItem createItem = new CreateItem(
                thumbnail,
                name,
                realName,
                location,
                isAlive
        );

        headers.add("Host");
        headers.add("restool-sample-app.herokuapp.com");
        log.error("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        Response item = apiBase.postRequest(baseUrl, createItem, headers, "/api/character");
        apiBase.checkStatusCode(item,"300");
        itemId = item.path("id");
        driver.get("http://dsternlicht.github.io/RESTool/#/characters?search=");
    }

    @Test
    public void checkItem() throws InterruptedException {
        MixTestPage mixTestPage = new MixTestPage(driver);
        mixTestPage.checkItemByItemValue(itemId);
    }

    @AfterMethod
    public void cleanUpItem(){
        Response delete = apiBase.deleteRequest(baseUrl, "", null,
                headers, "/api/character/" + itemId);
        apiBase.checkStatusCode(delete, "200");


    }
}
