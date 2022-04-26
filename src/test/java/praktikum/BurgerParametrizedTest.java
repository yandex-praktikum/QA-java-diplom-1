package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {

    private final Bun bun;
    private final float expectedPrice;

    public BurgerParametrizedTest(Bun bun, float expectedPrice) {
        this.bun = bun;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {new Bun ("TestBun", 5.00f), 12.00f},
                {new Bun ("TestBun", 0.0f), 2.0f},
                {new Bun ("TestBun", 5f), 12.0f},
                {new Bun ("TestBun", -3.0f), -4.0f},
                {new Bun ("TestBun", Float.MIN_VALUE), 2f},
                {new Bun ("TestBun", Float.MAX_VALUE), Float.POSITIVE_INFINITY}

        };
    }

    @Test
    public void getPriceForBurger() {

        Burger burger = new Burger ();
        burger.setBuns (bun);
        burger.ingredients.add (new Ingredient (IngredientType.SAUCE, "TestSauce", 1.0f));
        burger.ingredients.add (new Ingredient (IngredientType.FILLING, "TestFilling", 1.0f));
        float actualPrice = burger.getPrice ();
        assertEquals ("Price is incorrect.", expectedPrice, actualPrice, 0.0);
    }


}
