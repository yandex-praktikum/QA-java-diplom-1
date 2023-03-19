import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientSauceTest {
    @Test
    public void getSauceName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Assert.assertEquals("chili sauce", ingredient.getName());
    }

    @Test
    public void getSaucePrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Assert.assertEquals(300, ingredient.getPrice(), 0);
    }

    @Test
    public void getSauceType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

}
