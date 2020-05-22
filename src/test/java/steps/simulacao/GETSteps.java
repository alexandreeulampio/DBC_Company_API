package steps.simulacao;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utils.SetUp;

import static org.hamcrest.CoreMatchers.containsString;

public class GETSteps {
    RequestSpecification httpRequest;
    Response response;

    @Given("^Eu acesso a operacao GET do endpoint simulacoes$")
    public void euAcessoAOperacaoGETDoEndpointSimulacoes() {
        httpRequest = RestAssured.given().contentType(ContentType.JSON);
    }

    @When("^Eu executo a operacao GET$")
    public void euExecutoAOperacaoGET() {
        response = httpRequest.get(SetUp.urlBase + "simulacoes");
    }

    @Then("^Eu vejo todas as simulacoes cadastradas \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void euVejoTodasAsSimulacoesCadastradas(String StatusCode, String id, String nome, String cpf, String email, String valor, String parcelas, String seguro) {
        httpRequest.then().statusCode(Integer.parseInt(StatusCode));
        httpRequest
                .body(containsString(id))
                .body(containsString(nome))
                .body(containsString(cpf))
                .body(containsString(email))
                .body(containsString(valor))
                .body(containsString(parcelas))
                .body(containsString(seguro));
    }

    @Given("^Eu executo a opeacao GET do endpoint simulacoes$")
    public void euExecutoAOpeacaoGETDoEndpointSimulacoes() {
        httpRequest = RestAssured.given().contentType(ContentType.JSON);
    }

    @When("^Eu informo o numero de CPF \"([^\"]*)\"$")
    public void euInformoONumeroDeCPF(String cpf) {
        response = httpRequest
                .when()
                .get(SetUp.urlBase + "simulacoes/{cpf}", cpf);
    }

    @Then("^Eu vejo os dados \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void euVejoOsDados(String cpf, String StatusCode, String id, String nome, String email, String valor, String parcelas, String seguro) {
        Assert.assertEquals(Integer.parseInt(StatusCode), response.getStatusCode());

        if (Integer.parseInt(StatusCode) == 200) {
            JsonPath jsonPathEvaluator = response.jsonPath();

            Assert.assertEquals(jsonPathEvaluator.get("id"), Integer.parseInt(id));
            Assert.assertEquals(jsonPathEvaluator.get("nome"), nome);
            Assert.assertEquals(jsonPathEvaluator.get("cpf"), cpf);
            Assert.assertEquals(jsonPathEvaluator.get("email"), email);
            Assert.assertEquals(jsonPathEvaluator.get("valor"), Float.parseFloat(valor));
            Assert.assertEquals(jsonPathEvaluator.get("parcelas"), Integer.parseInt(parcelas));
            Assert.assertEquals(jsonPathEvaluator.get("seguro"), Boolean.parseBoolean(seguro));
        }
    }
}
