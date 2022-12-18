import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    private IngredientType type = FILLING;
    private String name = "Duck";
    private float price= 20.05f;

    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void IngredientGetsProperType() {
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void IngredientGetsProperName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void IngredientGetsProperPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.00f);
    }
}