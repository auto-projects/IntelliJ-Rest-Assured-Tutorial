package test.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.model.BuildJSONModel;
import test.model.PostBody;
import test.model.RequestCapability;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PATCHMethod implements RequestCapability{

    public static void main(String[] args) {
        String baseUri = "https://jsonplaceholder.typicode.com";

        // RequestSpecification object
        RequestSpecification request = given();
        request.baseUri(baseUri);

        // Content-type -> Header
        request.header(defaultHeader);

        // Form-up body
        PostBody postBody = new PostBody();
        postBody.setTitle("New Title");
        String postBodytoString = BuildJSONModel.parseJSONtoString(postBody);
        final String TARGET_POST_ID = "1";
        Response response = request.body(postBodytoString).patch("/posts/".concat(TARGET_POST_ID)); // PATCHMethod
        response.prettyPrint();

        // Verification
        response.then().body("title", equalTo(postBody.getTitle()));
    }
}
