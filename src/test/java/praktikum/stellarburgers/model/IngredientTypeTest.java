package praktikum.stellarburgers.model;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.stellarburgers.model.IngredientType.FILLING;
import static praktikum.stellarburgers.model.IngredientType.SAUCE;

public class IngredientTypeTest {
    @Test
    public void selectSauce() {
        Assert.assertEquals(IngredientType.valueOf("SAUCE"), SAUCE);
    }

    @Test
    public void selectFillingTest() {
        Assert.assertEquals(IngredientType.valueOf("FILLING"), FILLING);
    }
}
