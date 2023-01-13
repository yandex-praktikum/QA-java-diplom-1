import data.Data;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void checkThatIngredientGetsName(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, Data.STEAK, Data.STEAK_PRICE);
        Assert.assertEquals(Data.STEAK, ingredient.getName());
    }

    @Test
    public void checkThatIngredientGetsPrice(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, Data.STEAK, Data.STEAK_PRICE);
        Assert.assertEquals(Data.STEAK_PRICE, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void checkThatIngredientGetsType(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, Data.STEAK, Data.STEAK_PRICE);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
