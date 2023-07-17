package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;
import utils.JsonRequestBody;

public class POSTMethodBodyFromFile {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyFromFile(){
        JSONObject bodyRequest = JsonRequestBody.getJsonFormFile("request-shop-add-item-to-cart", "add_item_body");

        String  endpoint = "/cocart/v1/add-item";
        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void updateItemWithBodyFromFile(){
        JSONObject bodyRequest = JsonRequestBody.getJsonFormFile("request-shop-update-item-in-cart", "update_item_body");

        String  endpoint = "/cocart/v1/item";
        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }
}
