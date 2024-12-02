import api.Challenge;
import api.spec.Specifications;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.ValidatableResponse;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class ChallengeApiTest {
   // private final static  String URL = "http://158.160.42.61:4004/challenge/1";
   private final static  String URL = "http://158.160.42.61:4004/challenge";

    @Test
    @Owner("PAL")
    @DisplayName("Проверка названия челенджа")
    @Description("Выполняется проверка get запроса, что пришел ответ и названия челенджа соответствует заранее заданному")
    public  void checkChallengeTitle(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Challenge chl = given()
                .when()
                .get("/1")
                .then().log().all()
                .extract().as(Challenge.class);

        assertNotNull(chl.getId());
        assertEquals("the title", chl.getTitle());

    }
    @Test
    @Owner("PAL")
    @DisplayName("Негативная проверка челенджа")
    @Description("Выполняется проверка get запроса, что данный challengeId не существует")
    public  void checkChallengeNotExist(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError404());
        ValidatableResponse error = given()
                .when()
                .get("/0")
                .then().log().all()
                .assertThat()
                .statusCode(404);
    }
}
