package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GETMethod {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void getCartContents() {
        String endpoint = "/cocart/v1/get-cart";

        Response response = serviceHelper.sendGetRequest(endpoint);

        response.getBody().prettyPrint();

    }

    @Test
    public void countItems() {
        String endpoint = "/cocart/v1/count-items";

        Response response = serviceHelper.sendGetRequest(endpoint);

        response.getBody().print();
    }

    @Test
    public void restoreItemToCartWithParameters() {

        String key = "a8baa56554f96369ab93e4f3bb068c22";
        boolean returnCart = true;
        String endpoint = "/cocart/v1/item";
        String parameters = "?cart_item_key=" + key + "&return_cart=" + returnCart;

        Response response = serviceHelper.sendGetRequest(endpoint + parameters);

        response.getBody().prettyPrint();

    }

    @Test
    public void restoreItemToCartBody() {

        String bodyRequest = "{\n" +
                "    \"cart_item_key\": \"a8baa56554f96369ab93e4f3bb068c22\",\n" +
                "    \"return_cart\": \"true\"\n" +
                "}";
        String endpoint = "/cocart/v1/item";

        Response response = serviceHelper.sendGetRequest(endpoint, bodyRequest);

        response.getBody().prettyPrint();

    }

    @Test
    public void getTotal() {

        String parameters = "?html=true";
        String endpoint = "/cocart/v1/totals";

        Response response = serviceHelper.sendGetRequest(endpoint + parameters);

        response.getBody().prettyPrint();

    }
}
