package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import org.json.JSONObject;
import org.junit.Test;

public class POSTMethodBodyJSONObject {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyJSONObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 140);
        bodyRequest.put("quantity", 5);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void calculateWithBodyJSONObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void updateWithBodyJSONObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("cart_item_key", "1385974ed5904a438616ff7bdb3f7439");
        bodyRequest.put("return_cart", true);
        bodyRequest.put("quantity", 2);

        String endpoint = "/cocart/v1/item";

        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

}
