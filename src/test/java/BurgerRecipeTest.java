import data.Data;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerRecipeTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient filling;
    @Mock
    Ingredient souse;

    @Before
    public void setUp() {
        Mockito.when(bun.getName()).thenReturn(Data.BLACK_BUN);
        Mockito.when(filling.getName()).thenReturn(Data.STEAK);
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(souse.getName()).thenReturn(Data.KETCHUP);
    }

    @Test
    public void checkThatRecipeHasFillingName() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(filling);

        Assert.assertTrue(burger.getReceipt().contains(filling.getName()));
    }

    @Test
    public void checkThatRecipeHasFillingType() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(filling);

        Assert.assertTrue(burger.getReceipt().contains(filling.getType().toString().toLowerCase()));
    }

    @Test
    public void checkThatRecipeHasBunName() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(filling);

        Assert.assertTrue(burger.getReceipt().contains(bun.getName()));
    }

    @Test
    public void checkThatIngredientRemoved() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(filling);
        burger.addIngredient(souse);

        burger.removeIngredient(0);

        Assert.assertFalse(burger.ingredients.contains(filling));
    }

    @Test
    public void checkThatIngredientMoved() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(filling);
        burger.addIngredient(souse);

        burger.moveIngredient(1, 0);

        Assert.assertEquals(burger.ingredients.get(0).getName(), souse.getName());
    }
}
