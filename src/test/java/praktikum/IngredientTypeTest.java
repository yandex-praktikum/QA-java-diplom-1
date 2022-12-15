package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private Ingredient ingredient;

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Before
    public void setUp() {
        String name = "string";
        float price = 2.28F;
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Parameterized.Parameters
    public static Object[] typeOfIngredient() {
        return new Object[]{IngredientType.FILLING, IngredientType.SAUCE};
    }

    @Test
    public void getTypeOfIngredient() {
        assertEquals(ingredientType, ingredient.getType());
    }
}