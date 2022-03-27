import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String name;
    private final float price;
    private final IngredientType ingredientType;

    public IngredientTest(String name, float price, IngredientType ingredientType) {
        this.name = name;
        this.price = price;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientsData() {
        return new Object[][]{
                {"Сыр", 20, IngredientType.FILLING},
                {"Барбекю", 15, IngredientType.SAUCE},
                {"Майонез", 10, IngredientType.SAUCE}
        };
    }

    @Test
    public void checkGetPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals(price, actualPrice, 0);
    }

    @Test
    public void checkGetName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        String actualName = ingredient.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void checkGetIngredients() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actualInT = ingredient.getType();
        assertEquals(ingredientType, actualInT);
    }
}
