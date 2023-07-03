package programautomatycy.cart.service.test;

import helpers.ServiceHelper;
import org.junit.Test;

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
}

