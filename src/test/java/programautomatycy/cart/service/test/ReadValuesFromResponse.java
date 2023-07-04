package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

public class ReadValuesFromResponse {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void readCalculateValuesJsonPath() {

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String subtotal = response.getBody().jsonPath().getString("subtotal");
        System.out.println(subtotal);

        double subtotalTax = response.getBody().jsonPath().getDouble("subtotal_tax");
        System.out.println(subtotalTax);

        Object cartContentsTaxes = response.getBody().jsonPath().getMap("cart_contents_taxes").get("1");
        System.out.println(cartContentsTaxes);

        Map<String, Double> cartContentsTaxesMap = response.getBody().jsonPath().getMap("cart_contents_taxes"); //wiecej wartości w Obj
        System.out.println(cartContentsTaxesMap.get("1"));

    }

    @Test
    public void readValuesAddItemJSONObject() {
        org.json.JSONObject bodyRequest = new org.json.JSONObject();
        bodyRequest.put("product_id", 140);
        bodyRequest.put("quantity", 5);
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String jsonString = response.getBody().print();
        JSONObject obj = new JSONObject(jsonString);

        String key = obj.getString("key");
        System.out.println(key);

        Integer productId = obj.getInt("product_id");
        System.out.println(productId);

        String productName = obj.getString("product_name");
        System.out.println(productName);

        Double total = obj.getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");
        System.out.println(total);

    }


}
