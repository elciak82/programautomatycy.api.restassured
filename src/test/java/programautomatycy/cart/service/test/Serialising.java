package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import helpers.serialising.UpdateItemToCartRequestPOJO;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import helpers.serialising.AddItemToCartRequestPOJO;

public class Serialising {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItem(){
        int productId = 142;
        int quantity = 1;
        boolean returnCart = true;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(productId, quantity, returnCart);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest, endpoint);

        System.out.println(response.body().prettyPrint());


    }

    @Test
    public void updateCart(){
        int productId = 142;
        int quantity = 10;
        boolean returnCart = false;
        int updateQuantity = 1;

        AddItemToCartRequestPOJO addBodyRequest = new AddItemToCartRequestPOJO(productId, quantity, returnCart);
        String addEndpoint = "/cocart/v1/add-item";

        Response addResponse = serviceHelper.sendPostRequest(addBodyRequest, addEndpoint);
        String key = addResponse.getBody().jsonPath().getString("key");

        UpdateItemToCartRequestPOJO updateBodyRequest = new UpdateItemToCartRequestPOJO(key, returnCart, updateQuantity);
        String updateEndpoint = "/cocart/v1/item";

        Response updateResponse = serviceHelper.sendPostRequest(updateBodyRequest, updateEndpoint);
        System.out.println(updateResponse.body().prettyPrint());

    }
}
