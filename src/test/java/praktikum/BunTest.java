package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Название булочки: {0}, Цена булочки: {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Before
    public void createBun() {
        bun = new Bun(name, price);
    }

    @Test
    public void returnsCorrectName() {
        Assert.assertEquals("Неправильная булочка", name, bun.getName());
    }

    @Test
    public void returnsCorrectPrice() {
        Assert.assertEquals("Неправильная цена", price, bun.getPrice(), 0.0f);
    }
}
