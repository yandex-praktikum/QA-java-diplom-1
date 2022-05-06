package praktikum.ingredient;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

@Epic(value = "Stellar Burgers")
@Feature(value = "Burger Receipt")
@Story(value = "Ingredient in a burger")
public class IngredientTest {

    @Test
    @DisplayName("Get ingredient name")
    @Description("Create the new ingredient, then try to get name of ingredient")
    public void methodGetNameShouldReturnSameName() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    @DisplayName("Get ingredient price")
    @Description("Create the new ingredient, then try to get price of ingredient")
    public void methodGetPriceShouldReturnSamePrice() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.001);
    }
}
