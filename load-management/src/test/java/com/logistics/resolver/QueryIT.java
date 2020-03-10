package com.logistics.resolver;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class QueryIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Before
    public void setUp(){
        RestAssured.port = this.port;
    }

    @Test
    public void findAllLocationReturnsJsonWith200StatusCode(){

        given().log().all()
                .contentType("application/json")
                .body("{\n" +
                        "\t\"query\":\"{findAllLocations { id city state} }\"\n" +
                        "}")
                .post("/graphql")
                .then()
                //.log()
                .body("data.findAllLocations.id", hasItems("1", "2", "3"))
                .body("data.findAllLocations.city", hasItems("PLANO", "FRISCO", "ALLEN"))
                .statusCode(200);
    }

    @Test
    public void countLocationReturnsNumberOfLocation(){

        given().log().all()
                .contentType("application/json")
                .body("{\n" +
                        "    \"query\": \"{countLocations }\"\n" +
                        "}")
                .post("/graphql")
                .then()
                //.log();
                .body("data.countLocations", equalTo(8))
                .statusCode(200);
    }


}