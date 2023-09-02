package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    private static Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSomeIngredient() {
        return new Object[][]{
                {SAUCE, "Классический", 0.0f},
                {SAUCE, "Соус Spicy-X", 90.0f},
                {FILLING, "Довольно длинный ингридиент из мяса с шипами Антарианского плоскоходца", 1300.0f},
        };
    }
    @Before
    public void initIngredient() {
        ingredient = new Ingredient(this.type, this.name, this.price);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = ingredient.getPrice();
        assertEquals(this.price, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        String actualName = ingredient.getName();
        assertEquals(this.name, actualName);
    }

    @Test
    public void getTypeTest() {
        IngredientType actualType = ingredient.getType();
        assertEquals(this.type, actualType);
    }
}
