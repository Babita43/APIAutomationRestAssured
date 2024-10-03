package RestAssured.POJO;

import io.restassured.path.json.JsonPath;
import org.assertj.core.api.Assertions;
import org.testng.Assert;

public class VerifyUsingJsonPAth {
    public static void main(String[] args) {
        String paylaod= "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        //jsonpath
        JsonPath js = new JsonPath(paylaod);
        String a=  js.getString("firstname");
        System.out.println(a);
        //assert TestNg
        Assert.assertEquals(js.getString("firstname"),a);
        //assertj
        Assertions.assertThat(js.getString("firstname")).isNotBlank().isNotNull().isEqualTo(a);
    }
}
