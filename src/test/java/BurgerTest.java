import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Test
    public void shouldGetPriceWithNoIngredients() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(2.5F);
        Assert.assertEquals(5, burger.getPrice(), 0);
    }
    @Test
    public void shouldGetReceipt() {
        Burger burger = new Burger();
        when(bun.getName()).thenReturn("Булочка");
        when(bun.getPrice()).thenReturn(2.5F);
        burger.setBuns(bun);
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn("Тёмная материя");
        when(ingredient.getPrice()).thenReturn(1F);
        burger.addIngredient(ingredient);
        Assert.assertEquals("(==== Булочка ====)\r\n"+ "= filling Тёмная материя =\r\n" +"(==== Булочка ====)\r\n\r\n" + "Price: 6,000000\r\n", burger.getReceipt());
    }

    @Test
    public void shouldAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void shouldRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void shouldMoveIngredient() {
        Burger burger = new Burger();
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        burger.addIngredient(ingredient);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        burger.addIngredient(ingredient);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(IngredientType.SAUCE, burger.ingredients.get(0).getType());
    }

}
