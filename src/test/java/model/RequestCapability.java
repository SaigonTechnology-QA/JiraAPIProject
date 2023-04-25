package model;

import io.restassured.http.Header;

import java.util.function.Function;

public interface RequestCapability {
    String email = "<email>";
    String apiToken = "<API_Tokens>";
    Header defaultHeader = new Header("Content-type", "application/json");
    Header acceptJSONHeader = new Header("Accept", "application/json");

    static Header getAuthenticatedHeader(String encodeCredStr) {
        if (encodeCredStr == null) {
            throw new IllegalArgumentException("Error: encodeCredStr can not be null");
        }
        return new Header("Authorization", "Basic " + encodeCredStr);
    }

    // Functional Interface
    Function<String, Header> getAuthenticatedHeader = encodeCredStr -> {
        if (encodeCredStr == null) {
            throw new IllegalArgumentException("Error: encodeCredStr can not be null");
        }
        return new Header("Authorization", "Basic " + encodeCredStr);
    };

}
