import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {
    private IngredientType type;
    @Test
    public void setTypeSauce(){
        type = SAUCE;
        Assert.assertEquals(SAUCE, type);
    }
    @Test
    public void setTypeFilling(){
        type = FILLING;
        Assert.assertEquals(FILLING, type);
    }
}
