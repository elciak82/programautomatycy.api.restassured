package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import helpers.deserializing.addItem.AddItemResponse;
import helpers.deserializing.calculate.CalculateResponse;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class Deserializing {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyJSONObject() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 140);
        bodyRequest.put("quantity", 5);
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        AddItemResponse responseBody = response.as(AddItemResponse.class);


        System.out.println(responseBody.getKey());
        System.out.println(responseBody.getQuantity());
        System.out.println(responseBody.getProduct_name());

//        Map<String, String > total = (Map<String, String>) responseBody.getLine_tax_data().getTotal();
//        Object tot = total.get("1");
//
//        System.out.println(tot.toString());
//

        System.out.println(responseBody.getLine_tax_data().getTotal().getTotal1());
    }

    @Test
    public void calculateWithBodyJSONObject() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        CalculateResponse responseBody = response.as(CalculateResponse.class);

        System.out.println(responseBody.getSubtotal());
        System.out.println(responseBody.getSubtotal_tax());
        System.out.println(responseBody.getCart_contents_taxes().getCart_contents_taxes_1());
        System.out.println(responseBody.getTotal());
        System.out.println(responseBody.getTotal_tax());

    }
}
