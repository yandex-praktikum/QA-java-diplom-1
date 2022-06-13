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
        Assert.assertEquals("Неправильное Имя", expectedName, actualName);

    }
    @Test
    public void testGetIngredientPrice() {
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Неккоректная цена", expectedPrice,actualPrice,1);
    }
    @Test
    public void testGetIngredientType() {
        IngredientType actualPrice = ingredient.getType();
        Assert.assertEquals("Тип ингредиента не совпадает", expectedType, actualPrice);
    }
}