package DAY8;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
public class JsonSchemaValidationDemo {
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("spartan_api_url");
    }
    @Test
    public void JsonSchemaValidationForSpartan(){

            given()
                    .accept(ContentType.JSON)
                    .and()
                    .pathParam("id",10).
                    when()
                    .get("/api/spartans/{id}")
                    .then()
                    .statusCode(200)
                    .and()
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));
            //dogru calisip calismadigi kontrol icin ID degistirmiyoruz.onun yerine SingleSpartanSchema.json
        //icine girip mesela gender da male female degistiriyoruz
        }
}