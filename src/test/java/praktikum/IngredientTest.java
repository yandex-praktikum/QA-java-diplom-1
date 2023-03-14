package praktikum;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void getPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "соус 1", 100);
        float expPrice = 100;
        float actPrice = ingredient.getPrice();
        Assert.assertEquals(expPrice, actPrice, 0);
    }

    @Test
    void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "соус 1", 100);
        String expName = "соус 1";
        String actName = ingredient.getName();
        Assert.assertEquals("Имя ингридиента не верное", expName, actName);
    }

    @Test
    void getType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "соус 1", 100);
        String expType = "SAUCE";
        String actType = ingredient.getType().toString();
    }
}