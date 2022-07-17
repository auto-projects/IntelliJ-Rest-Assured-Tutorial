package test.test;

import com.google.gson.Gson;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.model.PostBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.equalTo;

public class POSTMethod {

    public static void main(String[] args) {
        String baseUri = "https://jsonplaceholder.typicode.com";

        // RequestSpecification object
        RequestSpecification request = given();
        request.baseUri(baseUri);

        // Content-type -> Header
        request.header(new Header("Content-type", "application/json; charset=UTF-8"));

        // Form-up request body
//        String postBody = "{\n" +
//                "  \"userId\": 1,\n" +
//                "  \"id\": 1,\n" +
//                "  \"title\": \"YUNA TL\",\n" +
//                "  \"body\": \"RAMBO - LAST BLOOD: 'I could have killed you 10 thousands times but I want you to be the last one, I will jump in and tear your heart into peaces then you could know exactly the feelings as what you have done to me!\"\n" +
//                "}";

        // Gson
        Gson gson = new Gson();
        PostBody postBody = new PostBody(1, 1, "YUNA TL", "RAMBO - LAST BLOOD: 'I could have killed you 10 thousands times but I want you to be the last one, I will jump in and tear your heart into peaces then you could know exactly the feelings as what you have done to me!");

        // Send POST request
        Response response = request.body(gson.toJson(postBody)).post("/posts"); // POSTMethod
        response.prettyPrint();

        // Verification
        response.then().statusCode(equalTo(201));
        response.then().statusLine(containsStringIgnoringCase("201 Created"));
        response.then().body("userId", equalTo(1));
        response.then().body("title", equalTo("YUNA TL"));
        response.then().body("body", equalTo("RAMBO - LAST BLOOD: 'I could have killed you 10 thousands times but I want you to be the last one, I will jump in and tear your heart into peaces then you could know exactly the feelings as what you have done to me!"));

    }

}
