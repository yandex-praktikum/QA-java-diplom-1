import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final String expected;
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientParamTest(String expected, String name, float price, IngredientType type) {
        this.expected = expected;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Parameterized.Parameters (name = "type: {0}")
    public static Object[][] getSumData() {
        return new Object[][] {
                {"SAUCE","test",2.5f, IngredientType.SAUCE},
                {"FILLING","test",2.5f, IngredientType.FILLING},
        };
    }

    @Test
    public void IngredientConstructorTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(expected,ingredient.getType().toString());
    }
}
