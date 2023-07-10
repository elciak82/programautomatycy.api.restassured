package helpers.deserializing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddItemResponse {

    @JsonProperty
    private String key;

    @JsonProperty
    private int product_id;

    @JsonProperty
    private int variation_id;

    @JsonProperty
    private Object variation;

    @JsonProperty
    private int quantity;

    @JsonProperty
    private String data_hash;

    @JsonProperty
    private LineTaxData line_tax_data;

    @JsonProperty
    private Double line_subtotal;

    @JsonProperty
    private Double line_subtotal_tax;

    @JsonProperty
    private Double line_total;

    @JsonProperty
    private Double line_tax;

    @JsonProperty
    private Object data;

    @JsonProperty
    private String product_name;

    @JsonProperty
    private String product_title;

    @JsonProperty
    private String product_price;




}
