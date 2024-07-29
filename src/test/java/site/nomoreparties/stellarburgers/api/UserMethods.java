package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import site.nomoreparties.stellarburgers.models.User;

import static io.restassured.RestAssured.given;

public class UserMethods {

    @Step("Send POST request to /api/auth/register")
    public static Response sendPostRequestToCreateUser(User user){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/register");
    }


    @Step("Send DELETE request to /api/auth/user")
    public static void sendDeleteUserRequest(User user, String token){
        given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .and()
                .body(user)
                .when()
                .delete("/api/auth/user")
                .then().statusCode(202);
    }

    @Step("Send POST request to /api/auth/login")
    public static Response sendPostRequestToLogInUser(User user){
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post("/api/auth/login");
    }
}
