import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void IngredientTypeHasTwoElements(){
        Assert.assertEquals(2, IngredientType.values().length);
    }
}
