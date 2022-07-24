package test.model;

import io.restassured.http.Header;

import java.util.function.Function;

public interface RequestCapability {

    Header defaultHeader = new Header("Content-type", "application/json; charset=UTF-8");
    Header acceptJSONHeader = new Header("Accept", "application/json");

    static Header getAuthenticatedHeader(String encodedCredString) {
        if (encodedCredString == null) {
            throw new IllegalArgumentException("ERROR !!! encodedCredString can't be null");
        }
        return new Header("Authorization", "Basic " + encodedCredString);
    }

    Function<String, Header> getAuthenticatedHeader = encodedCredString -> {
        if (encodedCredString == null) {
            throw new IllegalArgumentException("ERROR !!! encodedCredString can't be null");
        }
        return new Header("Authorization", "Basic " + encodedCredString);
    };
}
