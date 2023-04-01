import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String expectedName;
    private final float price;


    public BunTest(String expectedName, float price) {
        this.expectedName = expectedName;
        this.price = price;
    }

    @Parameterized.Parameters(name = "0:{index}")
    public static Object[][] dataBunForTest() {
        return new Object[][]{
                {"black bun",100},
                {"white bun",200},
                {"red bun",300},

        };
    }
    @Test
    public void checkNameBun(){
        Bun bun = new Bun(expectedName,price);
        Assert.assertEquals(expectedName,bun.getName());
        System.out.println(bun.getName());

    }
}
