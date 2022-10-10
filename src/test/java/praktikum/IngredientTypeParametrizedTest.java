package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class IngredientTypeParametrizedTest {

    private final String type;

    public IngredientTypeParametrizedTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "Тестовые типы ингредиентов: {0}")
    public static Collection name() {
        return Arrays.asList(new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        });
    }

    @Test
    public void shouldIngredientTypeTest() {
        Assert.assertEquals(IngredientType.valueOf(type).toString(), type);
    }
}
