import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(String name, float price, IngredientType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Parameterized.Parameters(name = "название: {0}, цена: {1}, тип: {2}")
    public static Object[][] testValues() {
        return new Object[][]{
                {"", 100, SAUCE},
                {"*", 0, FILLING},
                {"кетчуп", 100, SAUCE},
                {"майонез", 200, SAUCE},
                {"лук", 300, FILLING},
                {"котлета", 300, FILLING},
                {"длопдлваодплоыдлподывлопдыловпдло", 3000000.0665544f, SAUCE},
        };
    }

    @Test
    public void testCreateIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Некорректное название ингридиента", name, ingredient.getName());
        assertEquals("Некорректный прайс для ингридиента", price, ingredient.getPrice(), 0.0f);
        assertEquals("Некорректный тип для ингридиента", type, ingredient.getType());
    }
}