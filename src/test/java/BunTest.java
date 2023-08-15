import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Булочка с кунжутом", 150},
                {"Bun with sesame seeds", 150},
                {"Булочка с кунжутом", Float.MIN_VALUE},
                {"Bun with sesame seeds", Float.MAX_VALUE},
                {" ", 100},
                {"", 0},
                {null, -1},
                {"null", 0f},
                {"45656556", -100},
                {"@#$%%^%$#@", 1000},
                {"булкаиорироитцйудльлдьвплоотыолтлывтаолтавльдылдап твадптдлврьдльвлдптдтдпвап", -1000f},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        assertEquals("Имя не совпадает", name, bun.getName());
    }

    @Test
    public void getPriceTest(){
        assertEquals("Цена не совпадает", price, bun.getPrice(), 0);
    }
}

