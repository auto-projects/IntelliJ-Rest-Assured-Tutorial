package test.model;

import io.restassured.http.Header;

public interface RequestCapability {

    Header defaultHeader = new Header("Content-type", "application/json; charset=UTF-8");

    static Header getAuthenticatedHeader(String encodedCredtoString) {
        if (encodedCredtoString == null) {
            throw new IllegalArgumentException("ERROR !!! encodedCredtoString can't be null");
        }
        return new Header("Authorization", "Basic " + encodedCredtoString);
    }
}
