import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParametrizedTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] bunsData(){
        return new Object[][]{
                {"Булка", 1},
                {"Булка с сыром", Float.MIN_VALUE},
                {" ", 100},
                {"", 0},
                {null, 0},
                {"Пирожок с мясом", -1},
                {"Очень длинное название самой вкусной булки в этом мире или даже вселенной", Float.MAX_VALUE},
                {"856492", 40.123456f},
                {"!@#$%^&*()", 4.7E-16f},
        };

    }
    @Test
    public void checkName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void checkPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }


}