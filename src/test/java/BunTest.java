import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class BunTest {
    private final String name;
    private final float price;


    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "название: {0}, цена: {1}")
    public static Object[][] testValues() {
        return new Object[][]{
                {"", 100},
                {"*", 0},
                {"black bun", 100},
                {"white bun", 200},
                {"white bun", 300},
                {"white bun", 300},
                {"white bunwhite bunwhite bunwhite bun", 3000000.0665544f},
        };
    }

    @Test
    public void testGetNameAndGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Некорректное название булочки", name, bun.getName());
        assertEquals("Некорректный прайс для булочки", price, bun.getPrice(), 0.0f);
    }
}

