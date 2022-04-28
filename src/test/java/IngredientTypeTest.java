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
    private final IngredientType type;
    private final String name;
    private final float price;
    private final String errorMessage;

    public IngredientTypeTest(IngredientType type, String name, float price, String errorMessage) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.errorMessage = errorMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100.5F, "Некорректный тип для SAUCE"},
                {null, "hot sauce", 100.5F, "Некорректный тип для соус null"},
                {FILLING, "cutlet", 100.5F, "Некорректный тип для FILLING"}
        };
    }

    @Test
    public void testSuccessGetForIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(errorMessage, ingredient.getType(), type);

    }
}