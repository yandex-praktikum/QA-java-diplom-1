package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private String name;
    private  IngredientType type;
    private float price;;

    public IngredientTypeTest( IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ingredient type: {0}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {SAUCE, "szechuan sauc", 1},
                {FILLING, "beaf", 2},
        };
    }

    @Test
    public void checkIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Incorrect ingredient type", type, ingredient.getType());
    }
}