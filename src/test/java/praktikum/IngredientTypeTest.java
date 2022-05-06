package praktikum;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//на всякий соучай добавил проверку класса с множеством, хоть там и нет методов
public class IngredientTypeTest {
    @Test
    public void checkEnum() {

        String actualType = Arrays.toString(IngredientType.values());
        String expectedType = Arrays.toString(new String[]{"SAUCE", "FILLING"});
        Assert.assertEquals("Incorrect enum", expectedType, actualType);
    }

}
