package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;

    public IngredientTypeTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "{0} тип ингредиента")
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE},
                {FILLING},
        };
    }
    @Test
    public void testIngredientGetType() {
        Ingredient ingredient = new Ingredient(type, "hot sauce", 100);
        assertEquals(type, ingredient.getType());

    }
}

