package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredientSauce=new Ingredient(SAUCE,"Гречневая",7f);
    @Test
    public void getPricePositiveResult() { Assert.assertEquals("Некорректная цена",7f,ingredientSauce.getPrice(),0);}

    @Test
    public void getNamePositiveResult() {
        assertEquals("Не та булочка","Гречневая",ingredientSauce.getName());
    }

    @Test
    public void getTypePositiveResult() {
        Ingredient ingredientFilling=new Ingredient(FILLING,"Свежая",9f);
        Assert.assertEquals(FILLING, ingredientFilling.getType());
    }
}