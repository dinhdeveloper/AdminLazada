package com.dinh.thuhuyen.api;

public class APIUntil {
    private static String baseURL = "https://lazadaadmin.herokuapp.com/api/"; // https://mobishops.herokuapp.com/ http://vtnshop.herokuapp.com/

    public static APIService getServer() {
        return APIClient.getApiClientLSP(baseURL).create(APIService.class);
    }
}
