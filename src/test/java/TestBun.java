import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

/**
 * Парам. тест для класса {@link Bun}
 */
@RunWith(Parameterized.class)
public class TestBun {

    private String name;

    private float price;

    public TestBun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * В качестве параметров взяты "стандартные" данные и граничные значения типа float
     */
    @Parameterized.Parameters
    public static Object[][] getBun(){
        return new Object[][] {
                {"NAME", (float) 1.2},
                {"NAME NAME", (float) 1000},
                {"", (float) -3.4028235E+38},
                {"Закажи Меня Так Как Я Вкусно И Точка", (float) 3.4028235E+38}
        };
    }

    @Test
    public void testNewBun(){
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        float actualPrice = bun.getPrice();
        Assert.assertEquals(actualName, name);
        Assert.assertEquals(actualPrice, price, 0.0001);
    }
}

