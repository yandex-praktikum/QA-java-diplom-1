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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;
    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsToBurger() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredientMock);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredientMock);
        int index = burger.ingredients.indexOf(ingredientMock);
        burger.removeIngredient(index);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0, 1);
        assertEquals(ingredientFilling, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        Burger testBurger = new Burger();
        testBurger.setBuns(bunMock);
        testBurger.addIngredient(ingredientMock);
        Mockito.when(bunMock.getPrice()).thenReturn(42F);
        Mockito.when(ingredientMock.getPrice()).thenReturn(15F);
        float testBurgerPrice = testBurger.getPrice();
        assertEquals(99F,testBurgerPrice,99F - testBurgerPrice);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        Mockito.when(bunMock.getName()).thenReturn("bread");
        Mockito.when(bunMock.getPrice()).thenReturn(10f);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientMock.getName()).thenReturn("sweet onion");
        Mockito.when(ingredientMock.getPrice()).thenReturn(20f);
        String expectedReceipt2 = "(==== bread ====)" + "\r\n" + "= sauce sweet onion =" + "\r\n" + "(==== bread ====)" + "\r\n" + "\r\n" + "Price: 40,000000" + "\r\n";
        assertEquals(expectedReceipt2, burger.getReceipt());
    }

}