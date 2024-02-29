import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private String nameBun;
    private float priceBun;

    public BunParameterizedTest(String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Ржаная", Float.MIN_VALUE},
                {"Ржаная", Float.MAX_VALUE},
                {"Pjanaya", 100},
                {"", 100},
                {null, 100},
                {"1", 100},
                {"!", 100},
                {"Ржаная", 0},
                {"Ржаная", -100},
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(nameBun, priceBun);
        assertEquals(nameBun, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(nameBun, priceBun);
        assertEquals(priceBun, bun.getPrice(), Constant.DELTA);
    }
}