package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337f);
        Assert.assertTrue("Не верная цена ингридиента", ingredient.getPrice() == 1337.00f);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80f);
        Assert.assertEquals("Название ингридиента не совпадает", "Соус фирменный Space Sauce", ingredient.getName());
    }
}