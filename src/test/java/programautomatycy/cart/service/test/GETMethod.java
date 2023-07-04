package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import io.restassured.response.Response;
import org.junit.Test;

public class GETMethod {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void getCartContents() {
        String endpoint = "/cocart/v1/get-cart";

        Response response = serviceHelper.sendGetRequest(endpoint);

        response.getBody().prettyPrint();

    }
}
