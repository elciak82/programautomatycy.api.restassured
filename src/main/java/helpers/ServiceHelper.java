package helpers;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ServiceHelper {

    public void addItem(Integer productId, Integer quantity, Boolean returnCart, String endpoint){
        Response response = given()
                .auth()
                .preemptive() //form omitted
                .basic("elciak82@gmail.com", "Bartek2002!ycy")
                .queryParam("product_id", productId)
                .queryParam("quantity", quantity)
                .queryParam("return_cart", returnCart)
                .baseUri("https://programautomatycy.pl/wp-json")
                .post(endpoint);
    }
}
