package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"black bun", 100}
        });
    }

    private String name;
    private float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
        this.bun = new Bun(name, price);
    }

    @Test
    public void getName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPrice() {
        assertTrue(price == bun.getPrice());
    }

}