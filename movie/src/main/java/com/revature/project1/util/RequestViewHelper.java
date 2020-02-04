package com.revature.project1.util;

public class RequestViewHelper {

    public static String process(String uri) {

        switch (uri) {
            case "/movie/login.view":
                return "partials/login.html";
            case "/movie/register.view":
                return "partials/register.html";
            case "/movie/login/dashboard":
                return "partials/dashboard.html";
            case "/movie/home.view":
                return "partials/home.html";
            case "/movie/registerSuccess.view":
                return "partials/registerSuccess.html";
            case "/movie/employee.view":
                return "partials/employee.html";
            case "/movie/manager.view":
                return "partials/manager.html";
            case "/movie/createReimb.view":
                return "partials/createReimb.html";
            case "/movie/update.view":
                return "partials/update.html";

            default:
                return "";
        }
    }
}
