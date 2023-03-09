import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private Bun bun;
    private Ingredient ingredient;
    private float result;

    public BurgerParameterizedTest(Bun bun, Ingredient ingredient, float result) {
        this.bun = bun;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object [][] getCorrectGetPriceValue() {
        return new Object[][] {
                {new Bun("1", (float) 1.2), new Ingredient(SAUCE,"1", (float) 1.2), (float) 3.6000001},
                {new Bun("1", (float) 0), new Ingredient(SAUCE,"1", (float) 1.3), (float) 1.3},
                {new Bun("1", (float) 1.2), new Ingredient(SAUCE,"1", (float) 0), (float) 2.4000001},
        };
    }
    @Test
    public void getPriceTest() throws Exception {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assert burger.getPrice() == result;
    }
}



