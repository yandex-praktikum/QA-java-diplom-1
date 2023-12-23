package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTests {

    @Test
    public void getPriceIngredientTest(){
        float expected = 777f;
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"Мясо бессмертных моллюсков", 777f);
        float actual =  ingredient.getPrice();
        Assert.assertEquals(expected,actual, 0);
    }
    @Test
    public void getNameIngredientTest(){
        String expected = "Биокотлета из марсианской Магнолии";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"Биокотлета из марсианской Магнолии", 555f);
        String actual =  ingredient.getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getTypeIngredientTest(){
        IngredientType expected = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Соус традиционный галактический", 11f);
        IngredientType actual =  ingredient.getType();
        Assert.assertEquals(expected,actual);
    }
}
