package api.service;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

public class reqresinAPI{
    protected static Response response;
    private static final String REQRESIN_BASEURL = "https://reqres.in";

    public void getListUser(){
        SerenityRest.given()
                .get(REQRESIN_BASEURL + "/api/users?page=2");
    }

    public void PostLogin(){
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("email", "eve.holt@reqres.in");
        bodyJson.put("password", "cityslicka");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .post(REQRESIN_BASEURL + "/api/login");
    }

    public void UnsuccessLogin(){

        JSONObject bodyJson = new JSONObject();

        bodyJson.put("email", "peter@klaven");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .post(REQRESIN_BASEURL + "/api/login");
    }
    public void PutUpdate(){

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("name", "morpheus");
        bodyJson.put("job", "zion");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .post(REQRESIN_BASEURL + "/api/users/2");
    }
    public void DeleteUser(){
        SerenityRest.given()
                .delete(REQRESIN_BASEURL + "/api/users/2");
    }
}
