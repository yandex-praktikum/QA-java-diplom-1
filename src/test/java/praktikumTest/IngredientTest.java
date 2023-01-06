package praktikumTest;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void checkTypeIsValueOfEnum() {
        Ingredient ingredient = new Ingredient(SAUCE, "example_name", 2.34f);
        Assert.assertEquals(IngredientType.valueOf("SAUCE"), ingredient.getType());
    }

    @Test
    public void setCorrectPrice() {
        Ingredient ingredient = new Ingredient(FILLING, "test-name", 2.56f);
        Assert.assertEquals(2.56f, ingredient.getPrice(), 0.0);
    }

/**
 * По аналогии с другими классами цена не может быть отрицательной либо нулевой величиной.
 * Наименование также не может быть пустым.
 */
//    @Test
//    public void setNegativePriceIngredient() {
//        Ingredient ingredient = new Ingredient(SAUCE, "example_name", -4.23f);
//        Assert.assertTrue(ingredient.getPrice() > 0);
//    }
//
//    @Test
//    public void setZeroPriceIngredient() {
//        Ingredient ingredient = new Ingredient(SAUCE, "example_name", 0);
//        Assert.assertTrue(ingredient.getPrice() > 0);
//    }
//
//    @Test
//    public void setBlancOrSpaceName() {
//        Ingredient ingredient = new Ingredient(FILLING, "", 3);
//        Assert.assertTrue(ingredient.getName().trim().length() > 0);
//    }
}

