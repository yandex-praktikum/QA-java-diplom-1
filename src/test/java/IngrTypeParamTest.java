import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngrTypeParamTest {
    IngredientType type;
    int numberOfEnum;

    public IngrTypeParamTest(IngredientType type, int numberOfEnum) {
        this.type = type;
        this.numberOfEnum = numberOfEnum;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.SAUCE, 0},
                {IngredientType.FILLING, 1},
        };
    }

    @Test
    public void elementsOfEnumCorrect() {
        assertEquals (numberOfEnum, type.ordinal());
    }
}
