package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TryAssertions {

    //Asserts are used to verify the expected result is equals to actual result
    // asserts are of two types : Soft and Hard
    // Soft assert even after failing will print the line
    //hard does not print after failing the case
  @Test
    void car(){
     String name ="Rose";
      SoftAssert st = new SoftAssert();
      st.assertEquals("Rini", name);
      System.out.println("Execute it !!");
      st.assertAll();
    }
    @Test
    void student(){
      int totalStudents =30;
        Assert.assertEquals(10,totalStudents);
        System.out.println("Now execute me!!");
    }
}
