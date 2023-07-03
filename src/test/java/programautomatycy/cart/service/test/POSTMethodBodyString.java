package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class POSTMethodBodyString {

    private final ServiceHelper serviceHelper = new ServiceHelper();


    @Test
    public void addItemWithBodyString(){
        int productId = 142;
        int quantity = 2;
        Boolean returnCart = true;

        String bodyRequest = "{\n" +
                "   \"quantity\": " + quantity + ",\n" +
                "   \"product_id\": " + productId + ",\n" +
                "   \"return_cart\": " + true + "\n" +
                "}";
        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }

    @Test
    public void calculateWithBodyString(){
        boolean calculate = true;

        String bodyRequest = "{\n" +
                "   \"calculate\": " + true + ",\n" +
                "}";
        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }

    @Test
    public void updateItemWithBodyString() {
        String cartItemKey = "a8baa56554f96369ab93e4f3bb068c22";
        boolean returnCart = true;
        int quantity = 30;

        String bodyRequest = "{\n" +
                "    \"cart_item_key\": " + cartItemKey + ",\n" +
                "    \"return_cart\": " + true + ",\n" +
                "    \"quantity\":" + quantity +
                "}";

        String endpoint = "/cocart/v1/item";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }


}
