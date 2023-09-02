package praktikum;

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

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSomeBun() {
        return new Object[][]{
                {"Булочка №1", 0.0},
                {"Imported bun", 25.0},
                {"Булочка со впечетляющим длинным названием", 100.0},
        };
    }
    @Before
    public void initBun() {
        bun = new Bun(this.name, this.price);
    }

    @Test
    public static void getNameTest() {

    }

}
