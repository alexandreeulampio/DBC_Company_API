package steps.simulacao;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.SetUp;

public class DELETESteps {
    RequestSpecification httpRequest;
    Response response;

    @Given("^Eu acesso a operacao DELETE do endpoint simulacoes$")
    public void euAcessoAOperacaoDELETEDoEndpointSimulacoes() {
        httpRequest = RestAssured.given().contentType(ContentType.JSON);
    }

    @When("^Eu executo a operacao DELETE informando os campos \"([^\"]*)\"$")
    public void euExecutoAOperacaoDELETEInformandoOsCampos(String id) throws Throwable {
        response = httpRequest.when()
                .delete(SetUp.urlBase + "simulacoes/{id}", id);
    }

    @Then("^Eu visualizo o resultado \"([^\"]*)\"$")
    public void euVisualizoOResultado(String statusCode) {
        response.then()
                .statusCode(Integer.parseInt(statusCode));
    }
}
