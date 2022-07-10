import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void testEnumContainsValueSauce() {
        Assert.assertEquals("Enum не содержит значение SAUCE", "SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testEnumContainsValueFilling() {
        Assert.assertEquals("Enum не содержит значение FILLING", "FILLING", IngredientType.FILLING.name());
    }
}
