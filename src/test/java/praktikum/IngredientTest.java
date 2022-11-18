package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100F},
                {IngredientType.FILLING, "dinosaur", 200F},
                {IngredientType.FILLING, "sausage", 300F}
        };
    }

    @Test
    public void createIngredientTest() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Неверно присвоен тип", type, ingredient.getType());
        Assert.assertEquals("Неверно присвоено название", name, ingredient.getName());
        Assert.assertEquals("Неверно присвоена цена", price, ingredient.getPrice(), 0.1);
    }
}