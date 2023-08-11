import praktikum.Bun;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void getNameTest() {
        String name = "Булачка";
        float price = 123.45F;

        Bun bun = new Bun(name, price);

        String actual = bun.getName();

        assertEquals(name, actual);
    }

    @Test
    public void getPriceTest() {
        String name = "Булачка";
        float price = 123.45F;


        Bun bun = new Bun(name, price);

        float actual = bun.getPrice();

        assertEquals(price, actual, 0.0f);
    }

}
