package api.stepdef;

import api.service.reqresinAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import javax.xml.validation.Schema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class reqressinStefDef {

    reqresinAPI reqresin = new reqresinAPI();

    @When("user send GET users request to reqresin")
    public void userSendGETUsersRequestToReqresin() {
        reqresin.getListUser();
    }

    @Then("response status code should be {int}")
    public void responseStatusCodeShouldBe(int arg0) {
        reqresin.getListUser();
    }

    @When("user send POST login request to reqresin")
    public void userSendPOSTLoginRequestToReqresin() {
        reqresin.PostLogin();
    }

    @When("user send POST UnSuccesslogin request to reqresin")
    public void userSendPOSTUnSuccessloginRequestToReqresin() {
        reqresin.UnsuccessLogin();
    }

    @When("user send PUT Update request to reqresin")
    public void userSendPUTUpdateRequestToReqresin() {
        reqresin.PutUpdate();
    }

    @When("user send Delete request to reqresin")
    public void userSendDeleteRequestToReqresin() {
        reqresin.DeleteUser();
    }

    @And("response structure should match json schema {string}")
    public void responseStructureShouldMatchJsonSchema(String Schema) {
        String path = String.format("Schema/%s", Schema);
        restAssuredThat(response -> response.assertThat().body(matchesJsonSchemaInClasspath(path)));
    }
}
