package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private IngredientType ingredientType;
    private Ingredient ingredient;
    private String name;
    private float price;

    public IngredientParameterizedTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters(name = "Test data: {0}, {1}, {2}")
    public static Object[] createIngredientEntity() {
        return new Object[][]{
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "dinosaur", 200}
        };
    }

    @Test
    public void getIngredientTypeTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void getIngredientNameTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getIngredientPrice() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }
}