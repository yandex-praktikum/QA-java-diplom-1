import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String type;
    private final int elementNumber;

    public IngredientTypeTest(String type, int elementNumber) {
        this.type = type;
        this.elementNumber = elementNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getNameOfType() {
        return new Object[][]{
                {"SAUCE", 0},
                {"FILLING", 1},
                {"BUN", 2}
        };
    }

    @Test
    public void getNameOfIngredientType() {
        try {
            Assert.assertEquals(type, IngredientType.values()[elementNumber].toString());
        } catch (RuntimeException exception) {
            System.out.println("Произошло исключение RuntimeException");
        }
    }
}
