package com.combined.automation.stepDefinitions.API;

import com.combined.automation.pageObjects.API.BookingBuilder1;
import com.combined.automation.apiBuilder.Booking;
import com.combined.automation.presetClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingAPI extends BaseClass {

    @Test
    public void crateBooking()
    {
        int bookingId =
                given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .contentType(ContentType.JSON)
                        .body("{\n" +
                                "  \"firstname\": \"Sarath\",\n" +
                                "  \"lastname\": \"Kumar\",\n" +
                                "  \"totalprice\": 150,\n" +
                                "  \"depositpaid\": true,\n" +
                                "  \"bookingdates\": {\n" +
                                "    \"checkin\": \"2025-01-01\",\n" +
                                "    \"checkout\": \"2025-01-07\"\n" +
                                "  }\n" +
                                "}")
                        .when()
                        .post("/booking")
                        .then()
                        .statusCode(200)
                        .extract().path("bookingid");

        System.out.println(bookingId);

        System.out.println("******************");
    }

    @Test
    public void crateBookingBuilder()
    {
//        int bookingID=given().baseUri("https://restful-booker.herokuapp.com").contentType(ContentType.JSON).body(new BookingBuilder()).when().post("/booking")
//            .then()
//            .statusCode(200)
//            .extract().path("bookingid");


        RestAssured.baseURI=baseURL;
        //gRequest=given().header("contentType","ContentType.JSON").body(new BookingBuilder());
        gRequest=given().contentType(ContentType.JSON).body(BookingBuilder1.build()).log().body();
        gResponse=gRequest.post("/booking");
        System.out.println(gResponse.asPrettyString());
        System.out.println(gResponse.getStatusCode());
        Assert.assertEquals(gResponse.getStatusCode(),200);
        int bookingID=gResponse.jsonPath().getInt("bookingid");
        System.out.println(bookingID);
    }

    @Test
    public void crateBookingBuilderActual()
    {
//        int bookingID=given().baseUri("https://restful-booker.herokuapp.com").contentType(ContentType.JSON).body(new BookingBuilder()).when().post("/booking")
//            .then()
//            .statusCode(200)
//            .extract().path("bookingid");


        RestAssured.baseURI=baseURL;
        //gRequest=given().header("contentType","ContentType.JSON").body(new BookingBuilder());
        Booking booking=new Booking.BookingBuilder().setFirstname("Sarath1").setLastname("Kumar1").build();
        System.out.println("****************");
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());
        gRequest=given().contentType(ContentType.JSON).body(booking).log().body();

        System.out.println(gRequest);
        System.out.println("****************");

        gResponse=gRequest.post("/booking");
        System.out.println(gResponse.asPrettyString());
        System.out.println(gResponse.getStatusCode());
        Assert.assertEquals(gResponse.getStatusCode(),200);
        int bookingID=gResponse.jsonPath().getInt("bookingid");
        System.out.println(bookingID);
        Assert.assertEquals(gResponse.jsonPath().getString("booking.firstname"),booking.getFirstname());

        //Assertion
        System.out.println("Actual "+ gResponse.jsonPath().getString("booking.firstname"));
        System.out.println("Expected "+ booking.getFirstname());
    }
}
