import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.Ignore;
import org.junit.Test;
import org.apache.http.impl.client.DefaultHttpClient;
import static org.hamcrest.Matchers.equalTo;
import com.google.gson.*;

/**
 * Created by milleb on 5/9/2014.
 */
public class TestUser extends RestAssured {

    @Test
    public void NewUser() {
        when().
                get("http://localhost:62019/api/User").
        then().
                statusCode(200);
    }

    @Test
    public void GetAllUsers() {
        when().
                get("http://localhost:62019/api/User").
        then().
                body("User.size()", equalTo(3));
    }

    @Test
    public void GetSingelUser() {
        when().
                get("http://localhost:62019/api/User/1").
        then().
                body("Name", equalTo("Mille")).
                statusCode(200);
    }

    @Test @Ignore
    public void AddUser() {
        User user = new User();
        user.Name = "Mille";
        user.Age = 23;
        String userString = new GsonBuilder().create().toJson(user);
        given().
                contentType(ContentType.JSON).
                body(userString);
        when().
                post("http://localhost:62019/api/User").
        then().
                statusCode(202);
    }
}
