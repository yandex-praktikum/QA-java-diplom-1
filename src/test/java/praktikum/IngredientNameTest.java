package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)
public class IngredientNameTest {

    private final String name;
    private final String expected;

    public IngredientNameTest(String name, String expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientName() {
        Database database = new Database();
        return new Object[][] {
                { database.availableIngredients().get(0).getName(), "hot sauce"},
                { "some 125 name", "some 125 name"},
                { null, null},
        };
    }

    @Test
    public void shouldGetAnIngredientName()  {

        String actual = new Ingredient(FILLING,name,100).getName();
        assertEquals(expected, actual);

    }
}
