package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> bunData() {
        return Arrays.asList(new Object[][]{
                {"", 0},
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        });
    }

    @Test
    public void createBunWithEmptyNameAndZeroPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
        assertEquals(bunPrice, bun.getPrice(), 0);
    }
}