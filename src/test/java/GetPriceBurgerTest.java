import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetPriceBurgerTest {
    String bunName;
    float bunPrice;
    IngredientType ingredientType;
    String ingredientName;
    float ingredientPrice;

    public GetPriceBurgerTest(String bunName, float bunPrice, IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"black bun", 100F, IngredientType.SAUCE, "hot sauce", 50F},
                {"white bun", 150F, IngredientType.SAUCE, "chili sauce", 75F},
                {"red bun", 250F, IngredientType.FILLING, "cutlet", 150F},
        };
    }

    @Test
    public void getPriceBurger() {
        Burger burger = new Burger();
        Bun bun = new Bun(bunName, bunPrice);
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        burger.ingredients.add(ingredient);
        burger.setBuns(bun);
        float expectedPrice = bunPrice * 2 + ingredientPrice;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }
}
