package base;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.MapBuilder;
import models.RequestSpecBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import tests.exersize.MixTest;

import java.util.List;


import static io.restassured.RestAssured.given;

public class ApiBase {
    private static final Logger log = LogManager.getLogger(MixTest.class.getName());
    public String baseUrlReqres = "https://reqres.in";
    public String baseUrlGoRest = "https://gorest.co.in";
    public String baseUrlPostmanLocal = "https://6bd604fb-eca4-48d1-8c2c-bdfa6066b3c1.mock.pstmn.io";
    public String baseUrlPostman = "https://api.postman.com";
    public String baseUrlLocal = "http://localhost:80";
    public String baseNasaUrl = "https://api.nasa.gov";
    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();


    /**
     * Use this method to check status Code
     * @param response - Response object
     * @param statusCode - int expected status code
     */
    public void checkStatusCode(Response response, String statusCode) {
        String actualCode = String.valueOf(response.getStatusCode());
        try {
            Assert.assertEquals(actualCode, statusCode);
        } catch (Exception e){
            log.error("Status code is not match - In Class ApiBase line 37");
        }
//        if (actualCode.equals(statusCode)){
//            log.info("Status code is match - In Class ApiBase line 37");
//        } else {
//
//        }
//        ;
    }

    /**
     * Use this method to fetch data from server using method GET, with parameters and headers.
     * @param baseurl - String Base URI
     * @param endpoint - String endpoint
     * @param params - Map params
     * @param headers - Map headers
     * @return - Response object
     */
    public Response getRequest(String baseurl, List<String> params,
                               List<String> headers,  String endpoint) {
        Response get = given().
                spec(requestSpecBuilder.rSpec(baseurl,params,headers)).
                when().
                get(endpoint).
                then().
                log().all().
                extract().response();
        return get;
    }

    /**
     * Use this method to send POST request
     * @param baseurl - String Base URI
     * @param jsonObj
     * @param headers
     * @param endpoint
     * @return
     */
    public Response postRequest(String baseurl, Object jsonObj, List<String> headers, String endpoint) {
        RestAssured.useRelaxedHTTPSValidation();
        Response post = given().
                contentType("application/json").
                baseUri(baseurl).
                body(jsonObj).
                headers(MapBuilder.reqParam(headers)).
                when().log().all().
                post(endpoint).
                then().
                log().all().
                extract().response();
        return post;
    }

    /**
     * Use this method to send PUT request
     * @param baseurl
     * @param jsonObj
     * @param headers
     * @param endpoint
     * @return
     */
    public Response putRequest(String baseurl, Object jsonObj, List<String> headers, String endpoint) {
        Response put = given().
                contentType(ContentType.JSON).
                baseUri(baseurl).
                body(jsonObj).
                headers(MapBuilder.reqParam(headers)).
                when().
                put(endpoint).
                then().
                log().all().
                extract().response();
        return put;
    }

    /**
     * Use this method to send DELETE request
     * @param baseurl
     * @param jsonObj
     * @param params
     * @param headers
     * @param endpoint
     * @return
     */
    public Response deleteRequest(String baseurl, Object jsonObj, List<String> params, List<String> headers, String endpoint){
        Response post = given().
                contentType(ContentType.JSON).
                baseUri(baseurl).
                body(jsonObj).
                params(MapBuilder.reqParam(params)).
                headers(MapBuilder.reqParam(headers)).
                when().
                delete(endpoint).
                then().
                log().all().
                extract().response();
        return post;
    }
}