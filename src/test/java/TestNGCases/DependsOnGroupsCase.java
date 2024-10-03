package TestNGCases;

import org.testng.annotations.Test;

public class DependsOnGroupsCase {

    @Test (groups = {"login"})
    public void login() {
        System.out.println("Login");
    }

    @Test (groups = {"login"})
    public void resgister() {
        System.out.println("Register");
    }

    @Test (dependsOnGroups = {"login.*"})
    public void forget() {
        System.out.println("Reset password");
    }
}
