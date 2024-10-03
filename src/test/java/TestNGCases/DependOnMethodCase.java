package TestNGCases;

import org.testng.annotations.Test;

public class DependOnMethodCase {

    @Test(dependsOnMethods = {"zun"})
    public void AndFirstMethod() {
        System.out.println(" I thought I run first due to aplabetically");
    }

    @Test
    public void zun() {
        System.out.println("But if I run , then you can run, you depends on me");
    }
}
