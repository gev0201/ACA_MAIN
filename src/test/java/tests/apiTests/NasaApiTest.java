package tests.apiTests;

import base.ApiBase;
import com.fasterxml.jackson.databind.JsonSerializer;
import io.restassured.response.Response;
import models.CreateUserJson;
import org.apache.commons.lang3.ObjectUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.matchesPattern;

public class NasaApiTest extends ApiBase {

    private String asteroidId = "";

    @Test(priority = 0)
    public void getAsteroids() {
        String endpoint = "/neo/rest/v1/feed";
        List<String> params = new ArrayList<>();
        params.add("start_date");
        params.add("2021-01-01");
        params.add("end_date");
        params.add("2021-01-05");
        params.add("api_key");
        params.add("DEMO_KEY");

        Response allAsteroids = getRequest(baseNasaUrl, params, null, endpoint);
        checkStatusCode(allAsteroids, "200");
        assertThat(allAsteroids.path("element_count"), is(equalTo(83)));

//                postRequest(baseUrlReqres, createUserJson, null, usersListEndpoint);
//        checkStatusCode(newUser, "201");
//        assertThat(newUser.path("name"), is(equalTo("Gevorg")));
//        assertThat(newUser.path("id"), is(notNullValue()));
//        assertThat(newUser.path("createdAt"), matchesPattern(regex));
//        userId = newUser.path("id");
    }


    @Test(priority = 1)
    public void getAsteroidsDataSet() {
        String endpoint = "/neo/rest/v1/neo/browse/";
        List<String> params = new ArrayList<>();
        params.add("api_key");
        params.add("DEMO_KEY");

        Response allAsteroids = getRequest(baseNasaUrl, params, null, endpoint);
        checkStatusCode(allAsteroids, "200");
        asteroidId = allAsteroids.path("near_earth_objects[0].id");
        assertThat(allAsteroids.path("page.size"), is(equalTo(20)));
    }

    @Test(priority = 2)
    public void getAsteroidById() {
            if (asteroidId != "") {
                String endpoint = "/neo/rest/v1/neo/" + asteroidId;
                List<String> params = new ArrayList<>();
                params.add("api_key");
                params.add("DEMO_KEY");

                Response allAsteroids = getRequest(baseNasaUrl, params, null, endpoint);
                checkStatusCode(allAsteroids, "200");
                assertThat(allAsteroids.path("name_limited"), is(equalTo("Eros")));
            }
            else {
                Assert.assertTrue(false,
                        "Նախորդ թեստից ԱյԴի չի եկել )))))։");
            }
        }
    }
