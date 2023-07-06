package helpers;

import helpers.serialising.AddItemToCartRequestPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.GetPropertyValues;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class ServiceHelper {

    GetPropertyValues getPropertyValues = new GetPropertyValues();

    private final String LOGIN = getPropertyValues.getPropValue("login");
    private final String PASSWORD = getPropertyValues.getPropValue("password");
    private final String BASE_URI = getPropertyValues.getPropValue("shopServerUrl");

    private final SampleRest SAMPLE_REST = new SampleRest();

    public void addItem(Integer productId, Integer quantity, Boolean returnCart, String endpoint){
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //form omitted
                .basic(LOGIN, PASSWORD)
                .queryParam("product_id", productId)
                .queryParam("quantity", quantity)
                .queryParam("return_cart", returnCart)
                .baseUri(BASE_URI)
                .post(endpoint);
    }

    public void sendPostRequest(Map<String, Object> queryParamsBody, String endpoint){
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //form omitted
                .basic(LOGIN, PASSWORD)
                .queryParams(queryParamsBody)
                .baseUri(BASE_URI)
                .post(endpoint);
    }

    public Response sendPostRequest(String body, String endpoint){
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //form omitted
                .basic(LOGIN, PASSWORD)
                .body(body)
                .contentType(ContentType.JSON)
//                .contentType("application/json")
//                .header("Content-Type", "application/json")
                .baseUri(BASE_URI)
                .post(endpoint);
        return SAMPLE_REST.response;
    }

    public Response sendGetRequest(String endpoint){
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //form omitted
                .basic(LOGIN, PASSWORD)
                .baseUri(BASE_URI)
                .get(endpoint);

        return SAMPLE_REST.response;
    }

    public Response sendGetRequest(String endpoint, String body){
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //form omitted
                .basic(LOGIN, PASSWORD)
                .baseUri(BASE_URI)
                .body(body)
                .contentType(ContentType.JSON)
                .get(endpoint);

        return SAMPLE_REST.response;
    }

    public Response sendDeleteRequest(String endpoint){
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //form omitted
                .basic(LOGIN, PASSWORD)
                .baseUri(BASE_URI)
                .delete(endpoint);

        return SAMPLE_REST.response;
    }

    public Response sendDeleteRequest(String body, String endpoint){
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //form omitted
                .basic(LOGIN, PASSWORD)
                .baseUri(BASE_URI)
                .body(body)
                .contentType(ContentType.JSON)
                .delete(endpoint);

        return SAMPLE_REST.response;
    }

    public void sendPutRequest(String body, String endpoint){
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //form omitted
                .basic(LOGIN, PASSWORD)
                .body(body)
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .put(endpoint);
    }

    public void sendPatchRequest(String body, String endpoint){
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //form omitted
                .basic(LOGIN, PASSWORD)
                .body(body)
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .patch(endpoint);
    }

    public Response sendPostRequest(AddItemToCartRequestPOJO body, String endpoint){
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //form omitted
                .basic(LOGIN, PASSWORD)
                .body(body)
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .post(endpoint);
        return SAMPLE_REST.response;
    }
}

class SampleRest {
    public Response response;
}
