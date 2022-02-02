import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientMoveTest {
    @Mock
    Ingredient ingredient;

    @Test
    public void canMoveIngredientTest() {
        Burger burger = new Burger();

        burger.addIngredient(ingredient);

        Ingredient sausage = new Ingredient(IngredientType.FILLING,"сосиска",1);
        burger.addIngredient(sausage);

        int beforeSausageIndex = burger.ingredients.indexOf(sausage);

        burger.moveIngredient(beforeSausageIndex,0);

        int afterSausageIndex = burger.ingredients.indexOf(sausage);

        Assert.assertEquals(1,beforeSausageIndex);
        Assert.assertEquals(0,afterSausageIndex);
    }
}