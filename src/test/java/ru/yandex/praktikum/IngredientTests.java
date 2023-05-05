package ru.yandex.praktikum;
import org.junit.Assert;
import org.junit.Test;

public class IngredientTests {

    @Test
    public void getTypeIngredientTest(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"Сыр", 75f);
        IngredientType expected = IngredientType.FILLING;
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getNameIngredientTest(){
        String expected = "Сыр";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"Сыр", 75f);
        String actual =  ingredient.getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPriceIngredientTest(){
        float expected = 50f;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Барбекю", 50f);
        float actual = ingredient.getPrice();
        Assert.assertEquals(expected,actual,0);
    }
}