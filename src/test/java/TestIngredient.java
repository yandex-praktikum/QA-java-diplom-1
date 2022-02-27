import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class TestIngredient {
    @Test
    public void getPriceTest() {

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300F);
        Assert.assertEquals(300F, ingredient.getPrice(),0);

    }
    @Test
    public void getNameTest() {

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300F);
        Assert.assertEquals("chili sauce", ingredient.getName());

    }

    @Test
    public void getTypeTest() {

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300F);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());

    }
}
