package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void createIngredient() { //создаем объект
        ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 349);

    }
    //созжание без параметров
    @Test
    public void getPricePositiveTest() {
        Assert.assertEquals("В результате указана неверная цена",349, ingredient.getPrice(),0);
    }

    @Test
    public void getNamePositiveTest() {
        Assert.assertEquals("В результате указан неверное название ингридиента","sour cream", ingredient.getName());
    }

    @Test
    public void getTypePositiveTest() {
        Assert.assertEquals("В результате указан неверный тип ингридиента", IngredientType.SAUCE, ingredient.getType());
    }
}