import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParametrizedTest {
    String expected;
    String actual;

    public IngredientTypeParametrizedTest(String actual, String expected) {
        this.expected = expected;
        this.actual = actual;
    }

    @Parameterized.Parameters(name = "Тестовые данные Фактический:{0}, Ожидаемый:{1}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE.toString(), "SAUCE"},
                {IngredientType.FILLING.toString(), "FILLING"},
        };
    }

    @Test
    public void isIngredientTypeEnumContainsCorrectElementsTest() {
        assertEquals(expected, actual);
    }
}
