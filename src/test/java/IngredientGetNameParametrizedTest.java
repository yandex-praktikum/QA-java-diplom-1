import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientGetNameParametrizedTest {

    private static final Object SAUCE = IngredientType.SAUCE;
    private static final Object FILLING = IngredientType.FILLING;
    private final Object type;
    private final String name;
    private final float price;
    private final String expected;

    public IngredientGetNameParametrizedTest(Object type, String name, float price, String expected){
        this.type = type;
        this.name = name;
        this.price = price;
        this.expected = expected;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "кетчуп", 200, "кетчуп"},
                {FILLING, "свинина", 30, "свинина"},
        };
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient((IngredientType) type, name, price);
        String actualName = ingredient.getName();
        assertEquals("Название не совпадает",expected, actualName);
    }
}
