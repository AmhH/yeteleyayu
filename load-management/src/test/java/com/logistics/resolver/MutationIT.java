package com.logistics.resolver;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class MutationIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private static final String PATH = "/graphql";
    private static final String APP_JSON = "application/json";

    @Before
    public void setUp(){
        RestAssured.port = this.port;
        RestAssured.defaultParser = Parser.JSON;
    }

    @Test
    public void insertNewLocationReturn_IdOfNewObject(){
        Integer noBefore = getNumberOfLocation();

        given().log().all()
                .contentType(APP_JSON)
                .body("{\n" +
                        "   \"query\": \"mutation newLocation($city: String!, $state: String!, $zipCode: String!) { newLocation(city: $city, state: $state, zipCode: $zipCode){ id } }\",\n" +
                        "\t\"variables\":\"{ \\\"city\\\" : \\\"Dallas\\\", \\\"state\\\": \\\"TX\\\", \\\"zipCode\\\": \\\"76017\\\" }\"\n" +
                        "}")
                .post(PATH)
                .then()
                .body("data.newLocation.id", greaterThan("0"))
                .statusCode(200);

        Integer noAfter = getNumberOfLocation();

        assertThat(noAfter, is(noBefore + 1));
    }

    @Test
    public void updateLocationReturn_IdAndZipCode(){

        given().log().all()
                .contentType(APP_JSON)
                .body("{\n" +
                        "\t\"query\": \"mutation updateLocation($id: ID!, $city: String!, $state: String!, $zipCode: String!) { updateLocation(id: $id, city: $city, state: $state, zipCode: $zipCode){ id zipCode} }\",\n" +
                        "    \n" +
                        "    \"variables\": \"{ \\\"id\\\" : 1 , \\\"city\\\" : \\\"Plano\\\", \\\"state\\\": \\\"TX\\\", \\\"zipCode\\\": \\\"76017\\\"}\"\n" +
                        "}")
                .post(PATH)
                .then()
                //.log();
                .body("data.updateLocation.zipCode", equalTo("76017"))
                .statusCode(200);
    }

    @Test
    public void deleteNewLocationReturn_True(){
        Integer noBefore = getNumberOfLocation();

        given().log().all()
                .contentType(APP_JSON)
                .body("{\n" +
                        "\"query\": \"mutation deleteLocation($city: String!) {deleteLocation(city: $city)}\",\n" +
                        "    \n" +
                        " \"variables\": \"{\\\"city\\\": \\\"PLANO\\\" }\"\n" +
                        "}")
                .post(PATH)
                .then()
                .body("data.deleteLocation", is(true))
                .statusCode(200);

        Integer noAfter = getNumberOfLocation();

        assertThat(noAfter, lessThan(noBefore));
    }

    @Test
    public void deleteNewLocationReturn_False_CaseSensitive(){
        Integer noBefore = getNumberOfLocation();

        given().log().all()
                .contentType(APP_JSON)
                .body("{\n" +
                        "\"query\": \"mutation deleteLocation($city: String!) {deleteLocation(city: $city)}\",\n" +
                        "    \n" +
                        " \"variables\": \"{\\\"city\\\": \\\"Plano\\\" }\"\n" +
                        "}")
                .post(PATH)
                .then()
                .body("data.deleteLocation", is(false))
                .statusCode(200);

        Integer noAfter = getNumberOfLocation();

        assertThat(noAfter, equalTo(noBefore));
    }

    public static Integer getNumberOfLocation(){
        return   given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                        .when()
                        .body("{\n" +
                                "    \"query\": \"{countLocations }\"\n" +
                                "}")
                        .post(PATH)
                        .then()
                        .extract().response()
                        .body()
                        .jsonPath().get("data.countLocations");
    }
}
