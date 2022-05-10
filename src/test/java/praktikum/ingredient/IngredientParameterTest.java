package praktikum.ingredient;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

@RunWith(Parameterized.class)
@Epic(value = "Stellar Burgers")
@Feature(value = "Burger Receipt")
@Story(value = "Ingredient Parameter Test")
public class IngredientParameterTest {
    private IngredientType checkedIngredientType;

    public IngredientParameterTest(IngredientType checkedIngredientType) {
        this.checkedIngredientType = checkedIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    @DisplayName("Getting ingredient type in burger")
    @Description("Create the new burger with parameters and then get ingredient type")
    public void methodGetTypeShouldReturnSameType() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();

        Ingredient ingredient = new Ingredient(checkedIngredientType, name, price);
        Assert.assertEquals(checkedIngredientType, ingredient.getType());
    }
}
