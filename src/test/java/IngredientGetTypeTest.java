import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientGetTypeTest {

    private IngredientType type;
    private Ingredient ingredient;
    private String name = "Ingredient";
    private float price = 1.23f;

    public IngredientGetTypeTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "Ingredient type: {0}")
    public static Object[] answersData() {
        return new Object[]{IngredientType.FILLING, IngredientType.SAUCE};
    }

    @Test
    public void shouldGetType() {
        ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }



}


