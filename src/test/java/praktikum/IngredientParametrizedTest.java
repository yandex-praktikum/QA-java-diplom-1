package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    private static IngredientType type;

    public IngredientParametrizedTest(IngredientType type) {
        IngredientParametrizedTest.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeData() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }

    @Test
    public void getTypeShouldAcceptEnumValues() {
        Ingredient ingredient = new Ingredient(type, "Сырный", 2.55f);
        IngredientType expected = ingredient.getType();
        assertEquals(expected, type);
    }
}
