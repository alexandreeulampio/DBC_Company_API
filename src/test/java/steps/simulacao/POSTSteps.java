package steps.simulacao;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import utils.SetUp;

public class POSTSteps {
    RequestSpecification httpRequest;
    Response response;

    @Given("^Eu acesso a operacao POST do endpoint simulacoes$")
    public void euAcessoAOperacaoPOSTDoEndpointSimulacoes() {
        httpRequest = RestAssured.given().contentType(ContentType.JSON);
    }

    @When("^Eu executo a operacao POST informando os campos \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void euExecutoAOperacaoPOSTInformandoOsCampos(String StatusCode, String nome, String cpf, String email, String valor, String parcelas, String seguro) {
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
                .post(SetUp.urlBase + "simulacoes");
    }

    @Then("^Eu visualizo o resultado do cadastro \"([^\"]*)\" \"([^\"]*)\"$")
    public void euVisualizoOResultadoDoCadastro(String statusCode, String Mensagem) {
        response.then()
                    .statusCode(Integer.parseInt(statusCode));
    }
}
