package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class POSTMethodBodyFormData {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyFromData(){
        Integer productId = 142;
        Integer quantity = 2;
        Boolean returnCart = true;

        String  endpoint = "/cocart/v1/add-item";

        serviceHelper.addItem(productId, quantity, true, endpoint);

    }

    @Test
    public void addItemWithBodyMap() {
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("product_id", "142");
        queryParamsBody.put("quantity", 6);
        queryParamsBody.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }

    @Test
    public void calculateWithBodyMap() {
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("return", true);

        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }
}

