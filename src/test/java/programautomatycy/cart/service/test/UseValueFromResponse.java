package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class UseValueFromResponse {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void useResponseToUpdateItem(){
        JSONObject bodyRequest1 = new JSONObject();
        bodyRequest1.put("product_id", 142);
        bodyRequest1.put("quantity", 1);
        bodyRequest1.put("return_cart", false);

        String endpoint1 = "/cocart/v1/add-item";
        Response response1 = serviceHelper.sendPostRequest(bodyRequest1.toString(), endpoint1);

        String jsonString = response1.getBody().print();
        JSONObject obj = new JSONObject(jsonString);

        String key = obj.getString("key");
        System.out.println(key);

        JSONObject bodyRequest2 = new JSONObject();
        bodyRequest2.put("cart_item_key", key);
        bodyRequest2.put("quantity", 10);

        String endpoint2 = "/cocart/v1/item";
        Response response2 = serviceHelper.sendPostRequest(bodyRequest2.toString(), endpoint2);

        response2.getBody().prettyPrint();

    }
}
