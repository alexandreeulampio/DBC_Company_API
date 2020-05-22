package steps.simulacao;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import utils.SetUp;

public class PUTSteps {
    RequestSpecification httpRequest;
    Response response;

    @Given("^Eu acesso a operacao PUT do endpoint simulacoes$")
    public void euAcessoAOperacaoPUTDoEndpointSimulacoes() {
        httpRequest = RestAssured.given().contentType(ContentType.JSON);
    }

    @When("^Eu executo a operacao PUT informando os campos \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void euExecutoAOperacaoPUTInformandoOsCampos(String CPF_Origem, String StatusCode, String nome, String cpf, String email, String valor, String parcelas, String seguro) {
        JSONObject requestParams = new JSONObject();

        requestParams.put("nome", nome);
        requestParams.put("cpf", cpf);
        requestParams.put("email", email);
        requestParams.put("valor", valor);
        requestParams.put("parcelas", parcelas);
        requestParams.put("seguro", seguro);

        response = httpRequest.with()
                .body(requestParams)
                .when()
                .put(SetUp.urlBase + "simulacoes/{cpf}", CPF_Origem);
    }

    @Then("^Eu visualizo o resultado da alteracao \"([^\"]*)\" \"([^\"]*)\"$")
    public void euVisualizoOResultadoDaAlteracao(String statusCode, String Mensagem) {
        Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
    }


}
