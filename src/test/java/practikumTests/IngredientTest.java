package practikumTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static testData.TestConstants.DELTA;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    private Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getParams(){
        return new Object[][]{
                {IngredientType.SAUCE, "Соус шапокляк", 10.2f},
                {IngredientType.FILLING, "Мясо летающих коров", 100.55f},
                {null, null, 0}

        };
    }

    @Before
    public void initializeIngredient() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void getTypeReturnsTypeTest(){
        Assert.assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void getNameReturnsNameTest(){
        Assert.assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getPriceReturnsPriceTest(){
        Assert.assertEquals(ingredientPrice, ingredient.getPrice(), DELTA);
    }

}
