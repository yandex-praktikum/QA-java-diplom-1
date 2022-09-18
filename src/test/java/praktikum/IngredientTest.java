package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    // Делаем параметризацию данных на случай использования констант в методах getName() и getPrice()
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { IngredientType.SAUCE, "Соус Spicy-X", 90 },
                { IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337 },
        };
    }

    @Test
    public void getPriceFloatSameFloatValue() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameStringSameStringValue() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeEnumSameEnumValue() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}