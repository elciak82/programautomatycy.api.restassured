package helpers.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddItemToCartRequestPOJO {

    @JsonProperty
    private int product_id;
    @JsonProperty
    private int quantity;
    @JsonProperty
    private boolean return_cart;

    public AddItemToCartRequestPOJO(Integer productId, Integer quantity, boolean returnCart){
        this.product_id = productId;
        this.quantity = quantity;
        this.return_cart = returnCart;
    }

}
