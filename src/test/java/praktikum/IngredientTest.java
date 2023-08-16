package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    public final float price;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getIngredientInfo() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус традиционный галактический", 15.0F},
                {IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424.0F},
        };
    }

    @Test
    public void ingredientInfoTest() {

        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(), 0);

    }
}