package tests.apiTests;

import base.ApiBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AutomationExersizeAPI extends ApiBase {

    @Test(priority = 0)
    public void getProducts() {
        String url = "https://automationexercise.com/";
        String endpoint = "api/productsList";

        Response goods = getRequest(url, null, null, endpoint);
        JsonPath jp = getJsonPath(goods);

        checkStatusCode(goods, "200");
        assertThat(jp.get("products.id"), hasItem(1));
    }
}
