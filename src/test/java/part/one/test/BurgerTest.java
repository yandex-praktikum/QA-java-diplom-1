package part.one.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import part.one.Bun;
import part.one.Burger;
import part.one.Ingredient;
import part.one.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bunMock;

    @Mock
    Ingredient ingredientMock;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredientMock);
        assertTrue(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void testRemoveIngredient() {
        burger.ingredients.add(ingredientMock);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient firstIngredient = mock(Ingredient.class);
        Ingredient secondIngredient = mock(Ingredient.class);
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(secondIngredient, burger.ingredients.get(0));
        assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void testGetPriceWithMockedObjects() {
        when(bunMock.getPrice()).thenReturn(2.0f);
        when(ingredientMock.getPrice()).thenReturn(1.0f);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        float totalPrice = burger.getPrice();
        assertEquals(5.0f, totalPrice, 0.01);
    }

    @Test
    public void checkGetReceiptWithMockDatan() {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn("red bun");
        when(bun.getPrice()).thenReturn(50.0f);

        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("hot sauce");

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String actual = burger.getReceipt();
        String expected = String.format("(==== red bun ====)%n" +
                "= sauce hot sauce =%n" +
                "(==== red bun ====)%n" +
                "%n" +
                "Price: 100,000000%n");
        Assert.assertEquals(expected, actual);
    }
}
