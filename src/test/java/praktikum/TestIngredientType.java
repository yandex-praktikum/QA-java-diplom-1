package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TestIngredientType {
    final private IngredientType type;
    final String typeName;


    public TestIngredientType(String typeName, IngredientType type) {
        this.typeName = typeName;
        this.type = type;
    }

    @Parameterized.Parameters(name = "Тип ингредиента. Тестовые данные: {0} {1}")
    public static Object[] getInputData(){
        return new Object[][] {
                { "SAUCE", SAUCE },
                { "FILLING", FILLING },
        };
    }

    @Test
    public void testValueOfIngredientType() {
        Assert.assertEquals(type, IngredientType.valueOf(typeName));
    }

}
