import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

// Some change to trigger pull request

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;

public BunTest(String name, float price){
    this.name = name;
    this.price = price;
}

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }
@Test
public void bunNameTest(){
    Bun bun = new Bun(name,price);

    Assert.assertEquals("Bun name should be '" + name + "'", name, bun.getName());
}
@Test
public void bunPriceTest(){
        Bun bun = new Bun(name,price);

        Assert.assertEquals("Bun price should be '" + price + "'", price, bun.getPrice(),0.001);
    }

}
