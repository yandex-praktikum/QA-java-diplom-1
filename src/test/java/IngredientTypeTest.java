import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private Ingredient ingredient;
    String name = "Название соуса или начинки";
    float price = 100;


    public IngredientTypeTest(IngredientType ingredientType) {

        this.ingredientType = ingredientType;
    }

    @Before
    public void setUp() {

        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Parameterized.Parameters
    public static Object[] typeOfIngredient() {
        return new Object[]{
                FILLING,
                SAUCE
        };
    }

    @Test
    public void getTypeOfIngredient() {

        assertEquals(ingredientType, ingredient.getType());
    }

}
