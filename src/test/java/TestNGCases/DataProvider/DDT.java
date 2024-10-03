package TestNGCases.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT {
   @DataProvider
    public  Object[][] getData(){
        return  new Object[][]{
                new Object[]{"admin","password"},
                new Object[]{"admin","password"}
        };

    }
    @DataProvider ( parallel = true)
    public  Object[][] getDataParallel(){
        return  new Object[][]{
                new Object[]{"admin","password"},
                new Object[]{"admin0","password0"},
                new Object[]{"admin1","password1"}
        };
    }

    @Test (dataProvider = "getDataParallel" )
    public void login(String username,String password){
        System.out.println(username + ">" + password);
    }
}
