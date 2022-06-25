package praktikum;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void checkCorrectIngredientTypeListTest() {

        String actual = Arrays.toString(IngredientType.values());
        String expected = Arrays.toString(new String [] {"SAUCE","FILLING"});
        assertEquals("The List of ingredient types is not correct or missing",expected,actual);
    }

}
