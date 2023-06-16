package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class TestIngredientType {

    final private String enumValue;

    public TestIngredientType(String enumValue) {
        this.enumValue = enumValue;
    }

    @Parameterized.Parameters(name = "Проверка наличия: {0}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void checkEnumСontainsTest() {
        System.out.println(enumValue);
        Assert.assertEquals(enumValue, IngredientType.valueOf(enumValue).toString());
    }
}