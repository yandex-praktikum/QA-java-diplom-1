import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientNameTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private final String errorMessage;

    public IngredientNameTest(IngredientType type , String name, float price, String errorMessage) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.errorMessage = errorMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100, "Некорректное имя для соуса из двух слов с пробелом"},
                {SAUCE, "", 100.5F, "Некорректное имя для соуса без символов"},
                {FILLING, "cutlet", 100.5F, "Некорректное имя для соуса из одного слова"},
                {FILLING, null, 0, "Некорректное имя для соуса null"}
        };
    }

    @Test
    public void testSuccessGetPriceForIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(errorMessage, ingredient.getName(), name);

    }

}
