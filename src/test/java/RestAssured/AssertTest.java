package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class AssertTest {
   @Test
    public void type(){
String name = "Ankit";
//Assertions are used to verify the response in TestNg
       // it is of two types Soft and Hard - soft runs the code after failing but assert does not
       // mostly used is hard
       SoftAssert st = new SoftAssert();
       st.assertEquals(name, "Ankit");
       System.out.println("Print");
       st.assertAll();
//       Assert.assertEquals("Ankit", "ank");
//       System.out.println("Hi");
    }
}
