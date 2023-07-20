import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.IngredientType;
@RunWith(MockitoJUnitRunner.class)
public class IngredientTypeTest {
    @Test
    public void ingredientTypeTest(){
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
        Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }
}