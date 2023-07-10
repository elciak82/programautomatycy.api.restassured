package helpers.deserializing.calculate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculateResponse {

    @JsonProperty
    private String subtotal;

    @JsonProperty
    private int subtotal_tax;

    @JsonProperty
    private String shipping_total;

    @JsonProperty
    private int shipping_tax;

    @JsonProperty
    private Object shipping_taxes;

    @JsonProperty
    private int discount_total;

    @JsonProperty
    private int discount_tax;

    @JsonProperty
    private String cart_contents_total;

    @JsonProperty
    private int cart_contents_tax;

    @JsonProperty
    private CartContentsTaxes cart_contents_taxes;

    @JsonProperty
    private String fee_total;

    @JsonProperty
    private int fee_tax;

    @JsonProperty
    private Object fee_taxes;

    @JsonProperty
    private String total;

    @JsonProperty
    private int total_tax;

    public String getSubtotal() {
        return subtotal;
    }

    public int getSubtotal_tax() {
        return subtotal_tax;
    }

    public String getShipping_total() {
        return shipping_total;
    }

    public int getShipping_tax() {
        return shipping_tax;
    }

    public Object getShipping_taxes() {
        return shipping_taxes;
    }

    public int getDiscount_total() {
        return discount_total;
    }

    public int getDiscount_tax() {
        return discount_tax;
    }

    public String getCart_contents_total() {
        return cart_contents_total;
    }

    public int getCart_contents_tax() {
        return cart_contents_tax;
    }

    public CartContentsTaxes getCart_contents_taxes() {
        return cart_contents_taxes;
    }

    public String getFee_total() {
        return fee_total;
    }

    public int getFee_tax() {
        return fee_tax;
    }

    public Object getFee_taxes() {
        return fee_taxes;
    }

    public String getTotal() {
        return total;
    }

    public int getTotal_tax() {
        return total_tax;
    }
}
