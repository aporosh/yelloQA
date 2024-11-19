import api.Challenge;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class ChallengeApiTest {
    private final static  String URL = "http://158.160.42.61:4004/challenge/1";

    @Test
    public  void checkChallengeTitle(){
        String title = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL)
                .then().log().all()
                .extract().body().jsonPath().getJsonObject("challenge");

        //Assertions.assertNotNull(Challenge::getTitle, "Поиск не осуществился");
       // Assertions.assertNotNull(Challenge::getTitle, "");

    }
}
