package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private IngredientType ingredientType;
    private Ingredient ingredient;
    private String name = "string";
    private float price = 2.28F;

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Before
    public void setUp() {
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