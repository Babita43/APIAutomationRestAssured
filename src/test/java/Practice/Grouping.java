package Practice;

import org.testng.annotations.Test;

public class Grouping {
    //grouping - it allows you to organize and categorize test methods, making it easier
    // to run specific sets of tests.
   @Test (groups = {"smoke","reg"})
    void registration(){
        System.out.println("first signup");
    }
    @Test (groups={"smoke"})
    void login(){
        System.out.println("Login with cred");
    }
    @Test (groups={"reg"})
    void addToCart(){
        System.out.println("Add the items");
    }
    @Test(groups={"reg"})
    void checkout(){
        System.out.println("Pay and place order");
    }
}
