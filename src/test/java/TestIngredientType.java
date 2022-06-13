
import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class TestIngredientType {

    @Test
    public void checkTypes() {
        Assert.assertEquals("Название 1-го ингридиента", "SAUCE", IngredientType.values()[0].name());
        Assert.assertEquals("Название 2-го ингридиента", "FILLING", IngredientType.values()[1].name());
    }
}
