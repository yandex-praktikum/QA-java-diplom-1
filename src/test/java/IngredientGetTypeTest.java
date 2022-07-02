import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientGetTypeTest {
    private IngredientType type;
    private IngredientType expected;

    public IngredientGetTypeTest(IngredientType type) {
        this.type = type;
        this.expected = type;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING},
                {IngredientType.SAUCE}
        });
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(type, "", 0);
        Object actual = ingredient.getType();
        String message = "Метод getType вернул некорректное значение: " + actual + ". Ожидаемый результат: " + expected;
        Assert.assertEquals(message, expected, actual);
    }

}

