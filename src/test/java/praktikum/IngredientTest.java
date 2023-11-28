package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;
    private Ingredient ingredient;
    public IngredientTest(IngredientType type, String name, float price) {
        this.ingredientType = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getSumData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус", 100.0F},
                {IngredientType.FILLING, "Начинка", 150.0F},
        };
    }
    @Before
    public void init() throws Exception {
        ingredient = new Ingredient(ingredientType, name, price);
    }
    @Test
    public void getPriceTest() {
        Assert.assertEquals("Цена не совпадает",price, ingredient.getPrice(), 0);
    }
    @Test
    public void getNameTest() {
        Assert.assertEquals("Название не совпадает", name, ingredient.getName());
    }
    @Test
    public void getTypeTest() {
        Assert.assertEquals("Тип не совпадает",ingredientType, ingredient.getType());
    }
}
