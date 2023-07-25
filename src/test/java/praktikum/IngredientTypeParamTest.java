package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeParamTest {
    private final IngredientType type;
    private final String name;

    public IngredientTypeParamTest(IngredientType type, String name) {
        this.type = type;
        this.name = name;
    }
    @Parameterized.Parameters(name = "Тип {1}")
    public static Object[][] getType(){
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }
    @Test
    public void getIngredientType(){
        Assert.assertEquals("Неверно, попробуйте другое значение",name, type.name());
    }
}