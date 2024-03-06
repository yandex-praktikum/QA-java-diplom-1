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
    @Parameterized.Parameters(name = "Bun {index} -> Name: {0}, Price:{1} ")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }
    @Test
    public void getNameReturnedValidName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }
    @Test
    public void getPriceReturnedValidPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Sorry, price incorrect", price, bun.getPrice(), 0.0f);
    }
}
