import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Mock
    IngredientType type;

    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Проверка возвращения корректного значения. Тестовые данные: {0}, {1}. {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "Соус Spicy-X", 90},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 1337}
        };
    }

    @Test
    public void getPriceCheck() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameCheck() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeCheck() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }
}
