package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    //Проверка, что метод getPrice() возвращает введенное значение
    @Test
    public void checkGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        float actualPrice = ingredient.getPrice();
        float expectedPrice = 90;
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    //Проверка, что метод getName() возвращает введенное значение
    @Test
    public void checkGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        String actualName = ingredient.getName();
        String expectedName = "Соус Spicy-X";
        Assert.assertEquals(expectedName, actualName);
    }

    //Проверка, что метод getType() возвращает введенное значение
    @Test
    public void checkGetType() {
        Ingredient ingredient
                = new Ingredient(IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988);
        String actualType = String.valueOf(ingredient.getType());
        String expectedType = "FILLING";
        Assert.assertEquals(expectedType, actualType);
    }
}
