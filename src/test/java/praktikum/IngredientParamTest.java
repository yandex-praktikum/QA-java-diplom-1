
package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static praktikum.constants.Сonstants.*;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters (name = "Ингредиенты: Тип - {0}, Наименование - {1}, Цена - {2}")
    public static Object[][] testDateGen() {
        return new Object[][]{
                {SAUCE, NAME_CLASSIC_SAUCE, PRICE_0_0f},
                {SAUCE, NAME_SPICY_SAUCE, PRICE_90_0f},
                {FILLING,NAME_HOT_SAUCE, PRICE_100_0f},
                {FILLING, null, PRICE_200_0f},
                {null,NAME_FILLING_CUTLET, PRICE_100_0f},
                {null, null, PRICE_0_0f}
        };
    }

    @Test
    public void getIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), DELTA_0);
    }

}