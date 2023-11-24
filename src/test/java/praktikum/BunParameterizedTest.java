package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private Bun bun;
    private final String name;
    private final float price;

    public BunParameterizedTest(String name, float price)
    {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters (name = "{0} и {1}")
    public static Object[][] dataForTest()
    {
        //неявные ожидания классов эквивалентности, где они не нужны, не считаются. не вижу необходимости в этих тестах
        return new Object[][]{
                {"black bun", 100},
                {"", 200},
                {456, "зачем это все"},
        };
    }
    @Before
    public void createBun(){
        bun = new Bun(name,price);
    }

    @Test
    public void getNamePositiveTest() {
        Assert.assertEquals("Название булки не соотвевует переданному", name, bun.getName());
    }

    @Test
    public void getPricePositiveTest() {
        Assert.assertEquals("Цена булки не соотвевует переданной", price, bun.getPrice(),0);

    }
}