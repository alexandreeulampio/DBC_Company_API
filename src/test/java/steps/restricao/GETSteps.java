package steps.restricao;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utils.SetUp;

public class GETSteps {
    RequestSpecification httpRequest;
    Response response;

    @Given("^Eu executo a opeacao GET do endpoint restricao$")
    public void euExecutoAOpeacaoGETDoEndpointRestricao() {
        httpRequest = RestAssured.given().contentType(ContentType.JSON);
    }

    @When("^Eu informo o numero do CPF \"([^\"]*)\"$")
    public void euInformoONumeroDoCPF(String cpf) {
        response = httpRequest.get(SetUp.urlBase+"restricoes/{cpf}", cpf);
    }

    @Then("^Eu vejo o resultado da consulta de restricao \"([^\"]*)\" \"([^\"]*)\"$")
    public void euVejoOResultadoDaConsultaDeRestricao(String StatusCode, String Mensagem) throws Throwable {
        Assert.assertEquals(Integer.parseInt(StatusCode), response.getStatusCode());
        Assert.assertEquals(true, response.getBody().asString().contains(Mensagem));
    }
}
