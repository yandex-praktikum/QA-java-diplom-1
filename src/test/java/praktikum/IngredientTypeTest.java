package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    String type;

    public IngredientTypeTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{{"SAUCE"}, {"FILLING"},};
    }

    @Test
    public void testEnumIngredientType() {

        Assert.assertEquals(type, IngredientType.valueOf(type).toString());
    }
}
