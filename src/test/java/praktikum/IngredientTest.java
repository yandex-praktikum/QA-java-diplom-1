package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "Кетчуп", 30);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Цена не совпадает с ожидаемым значением", 30, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "Кетчуп", 30);
        String actualName = ingredient.getName();
        Assert.assertEquals("Название не совпадает с ожидаемым значением", "Кетчуп", actualName);
    }
}
