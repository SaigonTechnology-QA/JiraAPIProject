package model;

import io.restassured.http.Header;

import java.util.function.Function;

public interface RequestCapability {
    String email = "nxthich@gmail.com";
    String apiToken = "ATATT3xFfGF0KdJJwpkDVNkPpv1AnDmAJRYL3HiPlXvGxrXc0gATBqKy_QQPwn0Fw0wh7OmaSi9ndmdx1TcOsLr0guRfbH77mLpfepUnwmzIEyAlFEqzthssRR0yAhdo8Fnth5OLSvIWyetD-8zKJriY4IT_sKUBamywI8Dz7IB5gIC_yBPzPmU=EC91640A";
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
