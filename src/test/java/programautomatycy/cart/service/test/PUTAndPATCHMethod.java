package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PUTAndPATCHMethod {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void updateProductPut(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("key1", "value1");
        bodyRequest.put("key2", "value1");
        bodyRequest.put("key3", "value1");

        String endpoint = "/cocart/v1/someEndpoint";

        serviceHelper.sendPutRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void updateProductPatch(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("key1", "value1");
        bodyRequest.put("key2", "value1");
        bodyRequest.put("key3", "value1");

        String endpoint = "/cocart/v1/someEndpoint";

        serviceHelper.sendPatchRequest(bodyRequest.toString(), endpoint);
    }


}
