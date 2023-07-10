package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import helpers.deserializing.addItem.AddItemResponse;
import helpers.serialising.AddItemToCartRequestPOJO;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
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
}
