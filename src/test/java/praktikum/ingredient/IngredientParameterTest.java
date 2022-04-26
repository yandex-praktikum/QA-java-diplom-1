package praktikum.ingredient;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

@RunWith(Parameterized.class)

public class IngredientParameterTest {
    IngredientType checkedIngredientType;

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
    public void methodGetTypeShouldReturnSameType() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();

        Ingredient ingredient = new Ingredient(checkedIngredientType, name, price);
        Assert.assertEquals(checkedIngredientType, ingredient.getType());
    }

}
