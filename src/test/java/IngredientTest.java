import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;


//@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Mock
    IngredientType type;


    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type,"test", 2.5f);
        Assert.assertEquals("test",ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type,"test", 2.5f);
        Assert.assertEquals(2.5f,ingredient.getPrice(),0);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type,"test", 2.5f);
        Assert.assertEquals(type,ingredient.getType());
    }
}
