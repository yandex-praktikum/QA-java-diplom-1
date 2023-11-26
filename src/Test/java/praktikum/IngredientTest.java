package praktikum;


import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    Bun bun = new Bun("black bun", 100);
    Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);


    @Test
    public void getNameTest() {
        String expected = "cutlet";
        String actual = ingredientFilling.getName();
        Assert.assertEquals("Ошибка при получении названия ингредиента", expected, actual);
    }

    @Test
    public void getPriceTest() {
        float expected = 100;
        float actual = ingredientFilling.getPrice();
        Assert.assertEquals("Ошибка при получении цены ингредиента", expected, actual, 0);
    }

    @Test
    public void getTypeFillingTest() {
        IngredientType expected = IngredientType.FILLING;
        IngredientType actual = ingredientFilling.getType();
        Assert.assertEquals("Ошибка при получении цены ингредиента", expected, actual);
    }

    @Test
    public void getTypeSauceTest() {
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredientSauce.getType();
        Assert.assertEquals("Ошибка при получении цены ингредиента", expected, actual);
    }
}
