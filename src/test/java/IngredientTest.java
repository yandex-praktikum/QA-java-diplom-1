import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient;
    private final IngredientType expectedType = IngredientType.SAUCE;
    private final String expectedName = "Классическая";
    private final float expectedPrice = 70;

    @Before
    public void setUp(){
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Test
    public void testGetIngredientName() {
        String actualName = ingredient.getName();
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", expectedName, actualName);

    }
    @Test
    public void testGetIngredientPrice() {
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", expectedPrice,actualPrice,1);
    }
    @Test
    public void testGetIngredientType() {
        IngredientType actualPrice = ingredient.getType();
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", expectedType, actualPrice);
    }
}