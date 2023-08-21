import org.junit.Before;
import praktikum.Bun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;


    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "наименование - {0}, цена - {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"булка", 123},
                {"эта обратная булка", 321},
                {"обычная булочка", 101},
                {"турбо-булка", 545},
                {null, -0},
                {"угадайка-абвгдейка", 100},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getBunName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getBunPrice() {
        assertEquals(price, bun.getPrice(), 0);
    }
}