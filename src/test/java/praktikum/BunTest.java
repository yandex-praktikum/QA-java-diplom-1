package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    public final String name;
    public final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

@Parameterized.Parameters()
    public static Object[][] getData() {
        return new Object[][] {
                {"Плюшка",8},
                {"Круассан",7},
                {"Рогалик",10},
        };
}

    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}
