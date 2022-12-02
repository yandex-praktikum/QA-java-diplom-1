import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientsTest extends DataTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public IngredientsTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988},
                {IngredientType.SAUCE, "Соус традиционный галактический", 15},
        };
    }

    @Test
    public void getIngredientType() {
        theFirstIngredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientType, theFirstIngredient.getType());
    }

    @Test
    public void getIngredientName() {
        theSecondIngredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientName, theSecondIngredient.getName());
    }

    @Test
    public void getIngredientPrice() {
        theFirstIngredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientPrice, theFirstIngredient.getPrice(), 0);
    }
}
