package helpers.deserializing.addItem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Total {

    @JsonProperty("1")
    private Double total1;

    public Double getTotal1() {
        return total1;
    }
}
