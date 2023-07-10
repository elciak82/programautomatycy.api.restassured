package helpers.deserializing.calculate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartContentsTaxes {

    @JsonProperty("1")
    private int cart_contents_taxes_1;

    public int getCart_contents_taxes_1() {
        return cart_contents_taxes_1;
    }

}
