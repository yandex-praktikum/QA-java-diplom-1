package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientParams() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
                {null, "", 0}
        };
    }

    @Test
    public void shouldGetPriceReturnPrice() {
        ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void shouldGetNameReturnName() {
        ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void shouldGetTypeReturnType() {
        ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}