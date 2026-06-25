import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
    @Test
    public void hardAssert(){
        int actualCount = 3 ;
        int expectedCount = 3;

        Assert.assertEquals(actualCount,expectedCount, "Count Matched");
        System.out.println("This line is running means test is passed");
    }
    @Test
    public void softAssert(){
        SoftAssert sa = new SoftAssert();
        int actual = 3;
        int expected = 2;

        sa.assertEquals(actual,expected, "Count Matched");
        System.out.println("This line is running means test is passed");

        sa.assertAll();
    }
}
