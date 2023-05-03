import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {
    public IngredientType type;
    @Test
    public void setType(){
        type = SAUCE;
        Assert.assertEquals(SAUCE, type);
    }
}
