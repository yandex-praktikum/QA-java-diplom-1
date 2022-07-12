package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerPriceTest {

    private Bun bun;
    private String name;
    private final float price;
    private boolean testresult;
    private Ingredient ingredient;

    public BurgerPriceTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters(name = "price = {0}")
    public static Object[][] getTestBunData() {
        return new Object[][]{
                {0.1f},
                {1.0f},
                {1.000000000000001f},
                {100f},
                {200f},
                {300f},
                {10000f}

        };
    }

    @Before
    public void setUpBun() {
        name = "Bun";
        testresult = true;
        bun = new Bun(name, price);
        ingredient = new Ingredient(IngredientType.SAUCE, name, price);
    }

    @Test
    public void testBunPriceSuccess() {
        assertEquals("bun.getPrice() doesn't work properly", testresult, (bun.getPrice()) == price);
    }

    @Test
    public void testIngredientPriceSuccess() {
        assertEquals("ingredient.getName() doesn't work properly", testresult, name.equals(ingredient.getName()));
    }
}