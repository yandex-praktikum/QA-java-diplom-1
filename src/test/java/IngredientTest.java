import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private IngredientType type = SAUCE;
    private String name = "chili sauce";
    private float price = (float) 100;
    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.001);
    }
    @Test
    public void getNameTest() {
        Assert.assertEquals(name, ingredient.getName());
    }
    @Test
    public void getTypeTest() {
        Assert.assertEquals(type, ingredient.getType());
    }
}