import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] Buns() {
        return new Object[][]{
                {"", 0},
                {"bun", 12},
                {"bigbun", 1234},
                {"superbigbun", 12345678},
                {"!@#$%^&*(){:><>?+-=", -228},
        };
    }

    @Test
    public void SetBunReturnOurBunTests() {
        Burger burger = new Burger();
        burger.setBuns(new Bun(name, price));
        List<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(String.valueOf(price));
        List<String> actual = new ArrayList<>();
        actual.add(burger.bun.getName());
        actual.add(String.valueOf(burger.bun.getPrice()));
        assertEquals(expected, actual);
    }
}
