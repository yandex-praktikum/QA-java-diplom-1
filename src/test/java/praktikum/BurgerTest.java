package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;

    Burger burger = new Burger();
    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertThat(burger.bun, is(notNullValue()));
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(15f);
        float expected = (10f * 2) + 15f;
        assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        Mockito.when(ingredient2.getName()).thenReturn("Кетчуп");
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(15F);
        Mockito.when(ingredient2.getPrice()).thenReturn(5F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        String expected = "(==== Булочка с кунжутом ====)\r\n" +
                "= filling Котлета =\r\n" +
                "= sauce Кетчуп =\r\n" +
                "(==== Булочка с кунжутом ====)\r\n" +
                "\r\n" +
                "Price: 40,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }
}
