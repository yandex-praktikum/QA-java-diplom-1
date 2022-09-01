package StellarBurgerTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static java.lang.String.valueOf;

public class IngredientTypeTest {
    @Test
    @DisplayName("Ingredient sauce name test")
    @Description("Ingredient sauce name must be same as in enum")
    public void ingredientSauceTypeTest() {
        String resIngredient = valueOf(IngredientType.SAUCE);
        Assert.assertEquals("SAUCE", resIngredient);
    }

    @Test
    @DisplayName("Ingredient filling name test")
    @Description("Ingredient filling name must be same as in enum")
    public void ingredientFillingTypeTest() {
        String resIngredient = valueOf(IngredientType.FILLING);
        Assert.assertEquals("FILLING", resIngredient);
    }
}
