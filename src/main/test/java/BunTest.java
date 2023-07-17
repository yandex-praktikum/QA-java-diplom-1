import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    public String name;
    public float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bun() {
        return new Object[][]{
                {"Blabla", 0},
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {null, 1},

        };
    }

    @Test
    public void checkBunGetName(){
        Bun bunTest = new Bun(name, price);
        String actualBunName = bunTest.getName();
        Assert.assertEquals(name, actualBunName);

    }


    @Test
    public void checkBunGetPrice(){
        Bun bunTest = new Bun(name, price);
        float actualBunPrice = bunTest.getPrice();
        Assert.assertEquals(price, actualBunPrice, 0);

    }


}
