package qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import qa.api.APIUtils;

import java.io.File;
import java.util.List;

import static java.lang.Integer.parseInt;

public class apiTestSteps {
    APIUtils apiUtils = new APIUtils();
    String baseURI = "https://inventory-service.tixuk.io/api/v4/availability/products/1587/quantity/";
    String requestPath = "";
    Response response;

    @When("^I call Inventory service with quantity ([^\"]*) and from date ([^\"]*) and ([^\"]*) and query parameter ([^\"]*)$")
    public void getCallInventoryService(String quantity, String fromDate, String toDate, String queryParameter) {
        requestPath += quantity + File.separator + "from" + File.separator + fromDate + File.separator + "to" + File.separator + toDate;
        apiUtils.setBaseURI(baseURI);
        apiUtils.setQueryParameter(queryParameter);
    }

    @When("^use header key ([^\"]*) and header value ([^\"]*)$")
    public void setHeader(String key, String value) {
        apiUtils.setHeader(key, value);
    }

    @Then("^I get response ([^\"]*)$")
    public void responseValidation(String expectedResponseCode) {
        response = apiUtils.getResponse(requestPath);
        Assert.assertEquals(response.statusCode(), parseInt(expectedResponseCode));
    }

    @Then("^the minimum price is not Null")
    public void priceValidation() {
        JsonPath jsonPath = response.body().jsonPath();
        List<Integer> listOfShow = jsonPath.getList("response.minPrice");
        for (Integer each : listOfShow) {
            Assert.assertTrue(each != null);
        }
    }

    @And("^Error message is ([^\"]*)$")
    public void errorMessageValidation(String errorExpected) {
        JsonPath jsonPath = response.body().jsonPath();
        String errorReturned = jsonPath.getString("context.errors[0].message");
        Assert.assertEquals(errorReturned,errorExpected);
    }
}
