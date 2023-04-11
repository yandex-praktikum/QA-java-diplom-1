package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TestIngredient {
    final private IngredientType type;
    final private String name;
    final private float price;

    public Ingredient ingredient;

    public TestIngredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ингредиент. Тестовые данные: {0} {1} {2}")
    public static Object[] getInputData(){
        return new Object[][] {
                { SAUCE,  "",  0.0f},
                { FILLING, "name", 10.1f },
        };
    }

    @Before
    public void initData(){
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.001f);
    }
}
