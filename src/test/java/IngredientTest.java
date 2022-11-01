import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(FILLING, "dinosaur", 200f);
        Assert.assertEquals(200f, ingredient.getPrice(), 0);
    }

    @Test
    public void getName(){
        Ingredient ingredient = new Ingredient(FILLING, "dinosaur", 200f);
        Assert.assertEquals("dinosaur", ingredient.getName());
    }

    @Test
    public void getType(){
        Ingredient ingredient = new Ingredient(FILLING, "dinosaur", 200f);
        Assert.assertEquals(FILLING, ingredient.getType());
    }

}
