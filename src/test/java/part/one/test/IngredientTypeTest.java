package part.one.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import part.one.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType inputType;

    public IngredientTypeTest(IngredientType inputType) {
        this.inputType = inputType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        });
    }

    @Test
    public void testToString() {
        String expected = inputType == IngredientType.SAUCE ? "SAUCE" : "FILLING";
        assertEquals(expected, inputType.toString());
    }
}