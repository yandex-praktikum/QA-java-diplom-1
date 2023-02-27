import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeEnumContainsCorrectValues() {
        IngredientType[] enumArray = IngredientType.values();
        IngredientType[] expectedArray = new IngredientType[2];
        expectedArray[0] = SAUCE;
        expectedArray[1] = FILLING;
        Assert.assertEquals(expectedArray, enumArray);
    }
}
