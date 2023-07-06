package helpers.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateItemToCartRequestPOJO {

    @JsonProperty
    private String cart_item_key;
    @JsonProperty
    private boolean return_cart;
    @JsonProperty
    private int quantity;

    public UpdateItemToCartRequestPOJO(String key, boolean returnCart, int quantity){
        this.cart_item_key = key;
        this.return_cart = returnCart;
        this.quantity = quantity;
    }
}
