import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {SAUCE, "Сладкий", 100},
                {SAUCE, "Скитлз", 0.0000001F},
                {FILLING, "ΉΣ ͲΌṔṂṓᴢᴎ ϾΉΝΚΕΡςĤͷ♫", 3},
                {FILLING, "ЦАРСКИЙ БИФШТЕКС-МЕГАЛОДОООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООООН", 999999999999.99F},
                {SAUCE, null, 0},
                {null, "", -1},
        };
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Неверное название ингредиента", name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Некорректная стоимость ингредиента", price, ingredient.getPrice(), TestConstants.DELTA);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Неверный тип ингредиента", type, ingredient.getType());
    }

}
