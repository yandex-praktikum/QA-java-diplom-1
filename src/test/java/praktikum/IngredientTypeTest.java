package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTypeTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypeTest(){
        return new Object[][] {
                {IngredientType.FILLING, "FILLING", 100},
                {IngredientType.SAUCE, "SAUCE", 100}
        };
    }

    @Test
    public void ingredientTypeTest(){
        Assert.assertEquals(name, type.name());
    }
}