package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Ингредиенты {1}")
    public static Object[][] getIngredientType(){
        return new Object[][]{
                {IngredientType.FILLING, "Самый острый соус", 20},
                {IngredientType.SAUCE, "Самый сладкий соус", 100},
                {null, null, 0}
        };
    }
    @Test
    public void getIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("Неверный тип", type, actual);
    }
}