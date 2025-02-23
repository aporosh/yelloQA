import api.Challengers;
import api.spec.Specifications;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ChallengersApiTest {
    private final static  String URL = "http://158.160.42.61:4004/challenge";

    @Test
    @Owner("PAL")
    @DisplayName("Список всех участников челеджа")
    @Description("Пришел список со всеми участниками челенджа")
    public void listAllChallengers() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        Challengers challengersList = given()
                .when()
                .get("/1/challengers")
                .then().log().all()
                .extract().as(Challengers.class);
    }
}
