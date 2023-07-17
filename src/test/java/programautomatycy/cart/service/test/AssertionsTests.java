package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import helpers.deserializing.addItem.AddItemResponse;
import helpers.deserializing.updateItem.UpdateItemResponse;
import helpers.serialising.AddItemToCartRequestPOJO;
import helpers.serialising.UpdateItemToCartRequestPOJO;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class AssertionsTests {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemAndCheck() {

        int productId = 142;
        int quantity = 1;
        boolean returnCart = false;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(productId, quantity, returnCart);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest, endpoint);

        AddItemResponse responseBody = response.as(AddItemResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("15.00 zł", responseBody.getProduct_price());
        Assertions.assertEquals(142, responseBody.getProduct_id());
        Assertions.assertEquals("Bransoletka", responseBody.getProduct_name());

    }

    @Test
    public void updateItemAndCheck(){

        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("product_id", "1690");
        queryParamsBody.put("quantity", 1);
        queryParamsBody.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(queryParamsBody, endpoint);

        String key = response.getBody().jsonPath().getString("key");

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("cart_item_key", key);
        bodyRequest.put("quantity", 10);

        String endpointUpdate = "/cocart/v1/item";

        Response responseUpdate = serviceHelper.sendPostRequest(bodyRequest.toString(), endpointUpdate);

        Assertions.assertEquals(200, responseUpdate.getStatusCode());
        Assertions.assertEquals(10, responseUpdate.getBody().jsonPath().getInt("quantity"));

    }

    @Test
    public void addItemAndUpdateTest() {

        int productId = 142;
        int quantity = 10;
        boolean returnCart = false;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(productId, quantity, returnCart);

        String addEndpoint = "/cocart/v1/add-item";

        Response addResponse = serviceHelper.sendPostRequest(bodyRequest, addEndpoint);

        AddItemResponse addResponseBody = addResponse.as(AddItemResponse.class);
        String key = addResponseBody.getKey();
        String productName = addResponseBody.getProduct_name();

        int updatedQuantity1 = 2;

        UpdateItemToCartRequestPOJO bodyUpdatedRequest1 = new UpdateItemToCartRequestPOJO(key, returnCart, updatedQuantity1);

        String updateEndpoint = "/cocart/v1/item";

        Response updateResponse1 = serviceHelper.sendPostRequest(bodyUpdatedRequest1, updateEndpoint);
        UpdateItemResponse updateResponseBody1 = updateResponse1.as(UpdateItemResponse.class);
        String message1 = updateResponseBody1.getMessage();

        Assertions.assertEquals(200, updateResponse1.getStatusCode());
        Assertions.assertEquals(message1, "The quantity for " + "\"" + productName + "\"" + " has decreased to " + "\"" + updatedQuantity1 + "\".");

        int updatedQuantity2 = 7;

        UpdateItemToCartRequestPOJO bodyUpdatedRequest2 = new UpdateItemToCartRequestPOJO(key, returnCart, updatedQuantity2);

        Response updateResponse2 = serviceHelper.sendPostRequest(bodyUpdatedRequest2, updateEndpoint);
        UpdateItemResponse updateResponseBody2 = updateResponse2.as(UpdateItemResponse.class);
        String message2 = updateResponseBody2.getMessage();

        Assertions.assertEquals(200, updateResponse2.getStatusCode());
        Assertions.assertEquals(message2, "The quantity for " + "\"" + productName + "\"" + " has increased to " + "\"" + updatedQuantity2 + "\".");


    }
}
