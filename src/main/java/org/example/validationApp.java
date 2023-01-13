package org.example;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class validationApp {
    String baseLine = "http://127.0.0.1:8088";
    int num=1;



    @Test
    public void postHash() {

        JSONObject request = new JSONObject();
                request.put("password", "angrymonkey2212");

        given().contentType(ContentType.JSON).
                baseUri(baseLine).
                body(request.toJSONString()).
                when().
                post("/hash").
                then().
                statusCode(200).log().all().body(equalTo("num"));
        num++;

    }


    @Test
    public void getPass64() {

        given().contentType(ContentType.JSON).
                baseUri(baseLine).
                get("/hash/19").
                then().
                statusCode(200).log().all();

    }


    @Test
    public void stats () {

        given().contentType(ContentType.JSON).
                baseUri(baseLine).
                get("/stats").
                then().
                statusCode(200).log().all();

    }


    @Test
        public void postshutdown() {
        JSONObject request = new JSONObject();
        request.put("shutdown", "");

        given().contentType(ContentType.JSON).
                baseUri(baseLine).
                body(request.toJSONString()).
                when().
                post("/hash").
                then().
                statusCode(200).log().all();

    }




}