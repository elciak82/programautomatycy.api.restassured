package helpers.deserializing.updateItem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateItemResponse {

    @JsonProperty
    private String message;

    @JsonProperty
    private int quantity;

    public String getMessage() {
        return message;
    }

    public int getQuantity() {
        return quantity;
    }
}
