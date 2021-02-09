package com.example.demo.controller.constants;

import org.springframework.http.MediaType;

public final class ApiEndpoints {
    public static final String RESPONSE_CONTENTTYPE = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8";


    public static final String API_BASE_URL = "/api";

    public static final String PERSON_API_BASE_URL = API_BASE_URL + "/person";



    private ApiEndpoints() {

    }
}
