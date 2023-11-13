import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class IngredientTest extends BaseTest {

    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    private final Ingredient ingredientObj;


    public IngredientTest(IngredientType type, String name, float price) {
        ingredientObj = new Ingredient(type, name, price);

        ingredientType = type;
        ingredientName = name;
        ingredientPrice = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {IngredientType.FILLING, ingredientFillingName, random.nextFloat()},
                {IngredientType.SAUCE, ingredientSauceName, random.nextFloat()}
        };
    }


    @Test
    public void getNameAssertReturnValueTest(){
        Assert.assertEquals(ingredientName, ingredientObj.getName());
    }

    @Test
    public void getPriceAssertReturnValueTest(){
        Assert.assertEquals(ingredientPrice, ingredientObj.getPrice(), testDeltaRange);
    }

    @Test
    public void getTypeAssertReturnValueTest(){
        Assert.assertEquals(ingredientType, ingredientObj.getType());
    }

}
