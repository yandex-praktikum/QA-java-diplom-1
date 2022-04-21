import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

@RunWith(Parameterized.class)

public class IngredientTest {

    IngredientType checkedIngredientType;

    public IngredientTest(IngredientType checkedIngredientType) {
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

    @Test
    public void methodGetNameShouldReturnSameName() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();
        IngredientType type = IngredientType.SAUCE;

        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void methodGetPriceShouldReturnSamePrice() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();
        IngredientType type = IngredientType.FILLING;

        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.001);
    }
}
