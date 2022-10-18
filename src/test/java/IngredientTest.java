import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient;
    Bun bun;

    @Test
    public void getPriceIngredientTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200f);
        Assert.assertEquals("Price is incorrect", 200f, ingredient.getPrice(),0);
    }
    @Test
    public void getNameIngredientTest(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "sausage", 300f);
        Assert.assertEquals("Name is incorrect", "sausage", ingredient.getName());
    }
    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200f);
        Assert.assertEquals("Type is incorrect", IngredientType.FILLING, ingredient.getType());
    }
}
