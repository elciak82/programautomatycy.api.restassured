package programautomatycy.cart.service.test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class CartTests {

    @Test
    public void checkTest(){
        assertThat(RestAssured.config(), instanceOf(RestAssuredConfig.class));
    }
}
