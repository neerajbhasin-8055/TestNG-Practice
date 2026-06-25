import org.testng.annotations.Test;

public class Priority {


    @Test(priority = 1)
    public void login(){
        System.out.println("User Must be logged in first...");
    }
    @Test (priority = 3)
    public void logout(){
        System.out.println("Logging out....");
    }

    @Test(priority = 2)
    public void purchasing(){
        System.out.println("Purchasing items..");
    }


}