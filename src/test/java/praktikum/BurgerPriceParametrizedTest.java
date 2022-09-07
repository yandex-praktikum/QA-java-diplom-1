package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerPriceParametrizedTest {

    private final Bun bun;
    private final Ingredient ingredient;
    private final float expectedPrice;


    public BurgerPriceParametrizedTest(Bun bun, Ingredient ingredient, float expectedPrice) {
        this.bun = bun;
        this.ingredient = ingredient;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {new Bun("Флюоресцентная булка R2-D3", 988), new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90), 2066},
                {new Bun("Краторная булка N-200i", 1255), new Ingredient(IngredientType.FILLING,"Мясо бессмертных моллюсков Protostomia", 1337), 3847}

        };
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actualResult = burger.getPrice();

        assertEquals(expectedPrice, actualResult, 0.00001);
    }
}
