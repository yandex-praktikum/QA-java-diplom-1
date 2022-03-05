package praktikum;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valueOf() {

        String actual = Arrays.toString(IngredientType.values());
        String expected = Arrays.toString(new String [] {"SAUCE","FILLING"});

        assertEquals("The ENUM value is not correct",expected,actual);
    }
}