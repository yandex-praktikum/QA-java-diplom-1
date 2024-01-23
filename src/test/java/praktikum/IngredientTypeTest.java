package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType type;
    public IngredientTypeTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] orderData() {
        return new Object[][] {
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }
    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type,"Горчичный",10);
        IngredientType actual = ingredient .getType();
        Assert.assertEquals(type, actual);
    }

}