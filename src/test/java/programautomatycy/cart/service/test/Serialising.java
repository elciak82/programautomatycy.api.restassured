package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import io.restassured.response.Response;
import org.junit.Test;
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
}
