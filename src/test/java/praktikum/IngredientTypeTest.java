package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
public class IngredientTypeTest {
    //сравнение двух начинок
    @Test
    public void shouldBeTwoFillingsEquals() {
        Assert.assertEquals("Должна быть начинка (FILLING)",IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
    //отличие соуса от начинки
    @Test
    public void shouldBeSauceAndFillingsNotEquals() {
        Assert.assertNotEquals("Соуса быть не должно!", IngredientType.SAUCE, IngredientType.valueOf("FILLING"));
    }
}