package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        assertEquals(2,  burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredients() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1,  burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1,0);
        assertEquals(1, burger.ingredients.indexOf(ingredient));
    }

    @Test
    public void testGetPriceBurgerWithNoIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(84f);
        assertEquals(168,  burger.getPrice(), 0);
    }

    @Test
    public void testGetPriceBurgerWithOneIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        assertEquals(12,  burger.getPrice(), 0);
    }

    @Test
    public void testGetPriceBurgerWithTwoIngredients() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(114.14f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        Mockito.when(ingredient2.getPrice()).thenReturn(99f);
        assertEquals(328.28,  burger.getPrice(), 2);
    }

    @Test
    public void testGetReceiptBurgerWithNoIngredients() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(burger.getPrice()).thenReturn(299.50f);
        String expected = "(==== Краторная булка N-200i ====)\n" + "(==== Краторная булка N-200i ====)\n" + "\n" +
                "Price: 599.000000\n";
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetReceiptBurgerWithOneIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Говяжий метеорит (отбивная)");
        Mockito.when(burger.getPrice()).thenReturn(455.67f);
        String expected = "(==== Флюоресцентная булка R2-D3 ====)\n" + "= filling Говяжий метеорит (отбивная) =\n" +
                "(==== Флюоресцентная булка R2-D3 ====)\n" + "\n" + "Price: 455.670013\n";
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetReceiptBurgerWithTwoIngredients() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Сыр с астероидной плесенью");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn("Соус с шипами Антарианского плоскоходца");
        Mockito.when(burger.getPrice()).thenReturn(1003.05f);
        String expected = "(==== Краторная булка N-200i ====)\n" + "= filling Сыр с астероидной плесенью =\n" +
                "= sauce Соус с шипами Антарианского плоскоходца =\n" + "(==== Краторная булка N-200i ====)\n" +
                "\n" + "Price: 1003.049988\n";
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}