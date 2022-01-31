import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    String expectedIngredient;
    String actualIngredient;

    public IngredientTypeTest(String expectedIngredient, String actualIngredient) {

        this.expectedIngredient = expectedIngredient;
        this.actualIngredient = actualIngredient;

    }

    @Parameterized.Parameters
    public static Object[] getData() {

        return new Object[][]{

                {"SAUCE", IngredientType.SAUCE.name()},
                {"FILLING", IngredientType.FILLING.name()}

        };
    }

    @Test
    public void IngredientTypeTest() {

        assertEquals("Неверно определён тип ингредиента", expectedIngredient, actualIngredient);

    }

}
