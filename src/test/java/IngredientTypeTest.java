import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void valuesTest() {
        String[] expected = {"SAUCE", "FILLING"};

        for(int i = 0; i < IngredientType.values().length; i++) {
            String actual = IngredientType.values()[i].name();
            assertEquals(expected[i], actual);
        }
    }
}