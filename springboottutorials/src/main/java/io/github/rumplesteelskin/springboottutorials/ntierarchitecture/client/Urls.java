package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.client;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class Urls {
    private static final String BASE_URL = "http://localhost:8080/";

    @NoArgsConstructor
    public static final class Address {
        private static final String CONTROLLER = "location/";

        public static final String GET = BASE_URL + Address.CONTROLLER + "getAddress/";
    }

}
