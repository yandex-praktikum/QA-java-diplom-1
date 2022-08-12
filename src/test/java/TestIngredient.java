import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

/**
 * Парам. Тест для класса {@link Ingredient}
 */
@RunWith(Parameterized.class)
public class TestIngredient {

    private IngredientType type;
    private String name;
    private float price;

    public TestIngredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][]{
                {SAUCE, "NAME", (float) 0},
                {SAUCE, "", (float) -3.4028235E+38},
                {SAUCE, "Соус Heinz С Закрашенным Логотипом Макдональдса", (float) 3.4028235E+38},
                {FILLING, "The best Начинка начиночная Начиночка", (float) 3.4028235E+38},
                {FILLING, "", (float) -3.4028235E+38},
                {FILLING, "NAME", (float) 0},

        };
    }

    @Test
    public void TestNewIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(ingredient.getName(), name);
        Assert.assertEquals(ingredient.getType(), type);
        Assert.assertEquals(ingredient.getPrice(), price, 0.0001);
    }
}
