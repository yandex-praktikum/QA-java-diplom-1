import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Test data {index} >> Name: {0}, Price: {1}")
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Вкусная", 15},
                {null, 0},
                {"testy bun", 20},
                {"blackstar005", 150},
                {"", 98},
                {"@$#$%@^!&#%*()_@&&#^(", 55},
                {"regulsr", -35},
                {"special", 0.452342232131f},
                {"   ", 0},
                {"Lognstringfewdjwqwworldsandsoobobob", 122},
                {"1234567", 10},
                //{"bunTest", null},  // This Test failed
        };
    }
    @Test
    public void getName(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }
    @Test
    public void getPrice(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}