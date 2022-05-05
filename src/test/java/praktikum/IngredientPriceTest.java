package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientPriceTest {

    private final float price;
    private final float expected;

    public IngredientPriceTest(float price, float expected) {
        this.price = price;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{0} - передаем цену ингредиента, {1} - получаем ожидаемый результат")
    public static Object[][] getIngredientPrice() {
        Database database = new Database();
        return new Object[][]{
                {database.availableIngredients().get(5).getPrice(), 300},
                {400, 400},
                {1122525224111200.50f, 1122525224111200.50f},
                {295522.12345f, 295522.12345f},
                {0, 0}
        };
    }

    @Test
    public void shouldGetIngredientPrice() {

        float actual = new Ingredient(SAUCE, "имя", price).getPrice();
        assertEquals("Цена ингредиента соответствует ожидаемой", expected, actual, 0);

    }

}
