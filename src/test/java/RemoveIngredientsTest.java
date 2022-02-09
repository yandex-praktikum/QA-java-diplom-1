import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class RemoveIngredientsTest {

    @Mock
    Ingredient ingredient;

    @Test
    public void canRemoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        int sizeBeforeRemove = burger.ingredients.size();

        burger.removeIngredient(sizeBeforeRemove-1);

        int sizeAfterRemove = burger.ingredients.size();

        Assert.assertEquals(1,sizeBeforeRemove-sizeAfterRemove);
    }
}