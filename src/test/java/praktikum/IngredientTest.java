package praktikum;
import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    @Test
    public void getPrice() {
        float price = 10;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Горчичный",price);
        float actual = ingredient.getPrice();
        Assert.assertEquals(price, actual,0);
    }

    @Test
    public void getName() {
        String name = "Горчичный";
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,name,10);
        String actual = ingredient .getName();
        Assert.assertEquals(name, actual);
    }

    @Test
    public void getType() {
        IngredientType type = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(type,"Горчичный",10);
        IngredientType actual = ingredient .getType();
        Assert.assertEquals(type, actual);
    }
}