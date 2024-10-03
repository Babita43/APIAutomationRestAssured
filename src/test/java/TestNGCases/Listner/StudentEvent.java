package TestNGCases.Listner;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(CustomListener.class)  - for Iexecution

@Listeners(CustomListenerITest.class)
public class StudentEvent {
    @Test
    public void school() {
        System.out.println("his school timings is 4 hrs");
    }

    @Test
    public void play() {
        System.out.println("but after school, he directly goes to play");
    }

    @Test
    public void lunch() {
        System.out.println( "failed");
        Assert.assertTrue(false);
    }

    @Test(enabled = false)
    public void dinner() {
        System.out.println("skipped");

    }
}
