import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        Assert.assertEquals(burger.bun, null);
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        Assert.assertEquals(burger.ingredients.size(), 0);
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.size(), 1);
    }

    @Test
    public void testRemoveIngredient() {

    }

    @Test
    public void testMoveIngredient() {

    }

    @Test
    public void testGetPrice() {

    }

    @Test
    public void testGetReceipt() {

    }
}
