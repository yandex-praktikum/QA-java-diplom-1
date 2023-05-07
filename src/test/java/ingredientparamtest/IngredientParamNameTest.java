package ingredientparamtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamNameTest {
    private final  String expected;
    private final  String name;
    private final float price;
    private final IngredientType type;
    public IngredientParamNameTest(String expected, float price, String name, IngredientType type) {
        this.expected = expected;
        this.price = price;
        this.name = name;

        this.type = type;
    }
    @Parameterized.Parameters
    public static Object[][] checkIngredientName() {
        return new Object[][]{
                {"hot sauce",100,"hot sauce",SAUCE},
                {"sour cream",200,"sour cream",SAUCE},
                {"chili sauce",300,"chili sauce",SAUCE},
                {"cutlet",100,"cutlet",FILLING},
                {"dinosaur",200,"dinosaur",FILLING},
                {"sausage",300,"sausage",FILLING},
        };
    }
    @Test
    public void checkIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }
}
