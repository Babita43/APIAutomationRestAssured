package TestNGCases.DataProvider;

import Utils.UtilExcel;
import org.testng.annotations.Test;

public class DDTExcel {

@Test (dataProvider = "getData1" , dataProviderClass = UtilExcel.class)

public void Login(String username,String password){
    System.out.println("username" + username);
    System.out.println("password" + password);
}
}
