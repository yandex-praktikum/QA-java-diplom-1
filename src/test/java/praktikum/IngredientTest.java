package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class IngredientTest {
    private Ingredient ingredient;
    private String ingredientName = "cutlet";
    private IngredientType ingredientType = IngredientType.FILLING;
    private float ingredientPrice = 10;

    @Before
    public void createIngredientObject(){
        this.ingredient = new Ingredient(ingredientType,ingredientName, ingredientPrice);
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}
