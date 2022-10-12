import org.junit.Assert;
import org.junit.Test;

public class TestIngredient extends BaseTestIngredient {
    @Test
    public void checkIngredientGetPrice() {
        Assert.assertEquals(price, createIngredient().getPrice(), 0);
    }

    @Test
    public void checkIngredientGetName() {
        Assert.assertEquals(name, createIngredient().getName());
    }
}
