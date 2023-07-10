package helpers.deserializing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LineTaxData {

    @JsonProperty
    private Object subtotal;

    @JsonProperty
    private Object total;

    public Object getSubtotal() {
        return subtotal;
    }

    public Object getTotal() {
        return total;
    }

}
