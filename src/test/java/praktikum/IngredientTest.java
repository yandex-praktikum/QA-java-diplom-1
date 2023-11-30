package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    private final String INGREDIENT_NAME = "соус тысяча островов";
    private final float INGREDIENT_PRICE = 13.37f;
    private Ingredient ingredient;

    @Before
    public void setup() {
        ingredient = new Ingredient(IngredientType.SAUCE, INGREDIENT_NAME, INGREDIENT_PRICE);
    }

    @Test
    public void checkReturnIngredientType() {
        Assert.assertEquals("Тип ингредиента отличается", IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void checkReturnIngredientName() {
        Assert.assertEquals("Наименование ингредиента отличается", INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    public void checkReturnIngredientPrice() {
        Assert.assertEquals("Цена за ингредиент отличается", INGREDIENT_PRICE, ingredient.getPrice(), 0);
    }
}
