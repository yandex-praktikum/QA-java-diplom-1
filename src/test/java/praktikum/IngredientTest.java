package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус фирменный Space Sauce", 80.0f},
                {IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988.0f},
        };
    }
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Test
    public void getPriceReturnsCorrectIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameReturnsCorrectIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeReturnsCorrectIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }

}
