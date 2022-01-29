import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class AddIngredientsTest {
    @Mock
    Ingredient ingredient;

    @Test
    public void canAddIngredientsTest() {
        Burger burger = new Burger();

        int sizeBeforeAdd = burger.ingredients.size();

        burger.addIngredient(ingredient);

        int sizeAfterAdd = burger.ingredients.size();

        Assert.assertEquals(1,sizeAfterAdd-sizeBeforeAdd);
    }
}