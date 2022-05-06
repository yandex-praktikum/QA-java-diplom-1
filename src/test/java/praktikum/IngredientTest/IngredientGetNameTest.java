package praktikum.IngredientTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientGetNameTest {
    private final String name;
    private final String expectedName;

    public IngredientGetNameTest(String name, String expectedName) {
        this.name = name;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"hot sauce", "hot sauce"},
                {"cutlet", "cutlet"},
                {"", ""}
        };
    }

    @Test
    public void shouldCheckGetNameReturnExactName() {

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, 100.f);
        String actualName = ingredient.getName();
        assertEquals("return invalid name", expectedName, actualName);
    }

}
