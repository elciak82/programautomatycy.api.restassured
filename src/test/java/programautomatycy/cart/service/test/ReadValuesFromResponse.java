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

    @Test
    public void readValuesAddItemJSONObjectByKey() {
        org.json.JSONObject bodyRequest = new org.json.JSONObject();
        bodyRequest.put("product_id", 1696);
        bodyRequest.put("quantity", 5);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String jsonString = response.getBody().print();
        JSONObject obj = new JSONObject(jsonString);

        int productId = obj.getJSONObject("5cf21ce30208cfffaa832c6e44bb567d").getInt("product_id");
        System.out.println(productId);

        String productPrice = obj.getJSONObject("5cf21ce30208cfffaa832c6e44bb567d").getString("product_price");
        System.out.println(productPrice);

        Double total = obj.getJSONObject("5cf21ce30208cfffaa832c6e44bb567d").getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");
        System.out.println(total);

    }

    @Test
    public void getCartContentMap() {

        String endpoint = "/cocart/v1/get-cart";

        Response response = serviceHelper.sendGetRequest(endpoint);

        Map<String, Object> products = response.getBody().jsonPath().get();

        for (Map.Entry<String, Object> product : products.entrySet()) {
            System.out.println(product.getKey());

            Map<String, Object> values = (Map<String, Object>) product.getValue();
            System.out.println(values.get("product_id"));
            System.out.println(values.get("quantity"));
            System.out.println(values.get("product_name"));

            Map<String, Object> lineTaxData = (Map<String, Object>) values.get("line_tax_data");
            Map<String, Object> total = (Map<String, Object>) lineTaxData.get("total");
            System.out.println(total.get("1"));

            System.out.println("#############");
        }
    }

    @Test
    public void readValuesGetTotalsJSONObjectByKey() {
        org.json.JSONObject bodyRequest = new org.json.JSONObject();

        String parameters = "?html=true";
        String endpoint = "/cocart/v1/totals";

        Response response = serviceHelper.sendGetRequest(endpoint + parameters);

        String subtotal = response.getBody().jsonPath().getString("subtotal");
        System.out.println(subtotal);

        String cartContentsTax = response.getBody().jsonPath().getString("cart_contents_tax");
        System.out.println(cartContentsTax);

        String jsonString = response.getBody().prettyPrint();
        JSONObject obj = new JSONObject(jsonString);

        int cartContentsTaxes = obj.getJSONObject("cart_contents_taxes").getInt("1");
        System.out.println(cartContentsTaxes);

        String total1 = obj.getString("total");
        System.out.println(total1);

    }

}
