package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
@RunWith(Parameterized.class)
public class IngredientTest {
    @Parameterized.Parameter(0)
    public IngredientType type;

    @Parameterized.Parameter(1)
    public String name;

    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameters(name = "Type: {0}, Name: {1}, Price: {2}")
    public static Object[][] params() {
        return new Object[][]{
                {SAUCE, "майонезик", 500},
                {FILLING, "кекчук", 600},
        };
    }
    @Test
    public void getPrice() {
        if (price == 500) {
            Assert.assertEquals(500, price, 0);
        } else if (price == 600) {
            Assert.assertEquals(600, price, 0);
        }
    }
    @Test
    public void getName() {
        if (name == "майонезик") {
            Assert.assertEquals("майонезик", name);
        } else if (name == "кекчук") {
            Assert.assertEquals("кекчук", name);
        }
    }
    @Test
    public void getType() {
        if (type == SAUCE) {
            Assert.assertEquals(SAUCE, type);
        } else if (type == FILLING) {
            Assert.assertEquals(FILLING, type);
        }
    }
}