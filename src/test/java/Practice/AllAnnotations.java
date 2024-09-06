package Practice;

import org.testng.annotations.*;

public class AllAnnotations {
   @BeforeSuite
    void group(){
        System.out.println("Run before suite");
    }
@BeforeTest
    void group1(){
        System.out.println("Run before test");
    }
@BeforeClass
    void group2(){
        System.out.println("Run before class");
    }
@BeforeMethod
    void group3(){
        System.out.println("Run before method");
    }
@Test
    void testOne(){
        System.out.println("Run during test1");
    }
    @Test
    void testTwo(){
        System.out.println("Run during test2");
    }
@AfterMethod
    void group5(){
        System.out.println("Run after method");
    }
   @AfterClass
   void group6(){
       System.out.println("Run after class");
   }
    @AfterTest
    void group7(){
        System.out.println("Run after test");
    }
    @AfterSuite
    void group8(){
        System.out.println("Run after suite");
    }

}
