package com.protal.portal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class MainPageControllerTests {

    @Test
    public void currentSeasonEndpointConnectivityTest() {
        when().
                get("http://localhost:7777/portal/currentSeason").
                then().
                statusCode(200).
                body("statusCode", equalTo(200),
                        "status", equalTo("SUCCESS"));
    }

    @Test
    public void newsEndpointConnectivityTest() {
        when().
                get("http://localhost:7777/portal/news").
                then().
                statusCode(200).
                body("statusCode", equalTo(200),
                        "status", equalTo("SUCCESS"));
    }

    @Test
    public void socialMediaEndpointConnectivityTest() {
        when().
                get("http://localhost:7777/portal/socialMedia").
                then().
                statusCode(200).
                body("urls", notNullValue(),
                        "urls", not(""));
    }
}
