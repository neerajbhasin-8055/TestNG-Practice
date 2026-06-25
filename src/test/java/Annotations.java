import org.testng.annotations.*;

public class Annotations {
    @BeforeClass
    public void setup(){
        System.out.println("Opening browser...");
    }
    @BeforeMethod
    public void login(){
        System.out.println("Logging in...");
    }
    @Test
    public void searchFlight(){
        System.out.println("Searching for the flight..");
    }
    @AfterMethod
    public void logout(){
        System.out.println("Logging out...");
    }
    @AfterClass
    public void closing(){
        System.out.println("Closing Browser..");
    }
}
