package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bunMock = mock(Bun.class);

    @Mock
    Ingredient ingredientMock = mock(Ingredient.class);

    @Test
    public void setBunsTest() {
        Burger burger1 = new Burger();
        burger1.setBuns(bunMock);
        assertEquals(bunMock, burger1.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        assertEquals(1, Burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals(0, Burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredientOne = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientOne);
        burger.moveIngredient(2, 0);
        System.out.println(Burger.ingredients.get(0).name);
        assertEquals("cutlet", Burger.ingredients.get(0).name);
    }

    @Test
    public void getPriceBurgerTest() {
        Burger burger = new Burger();
        float expectedPrice = 400;
        when(bunMock.getPrice()).thenReturn(100F);
        when(ingredientMock.getPrice()).thenReturn(200F);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        assertEquals(expectedPrice, burger.getPrice(), 300);
    }

    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        when(bunMock.getName()).thenReturn("bun");
        when(bunMock.getPrice()).thenReturn(100F);
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("ingredient");
        when(ingredientMock.getPrice()).thenReturn(200F);
        String expected = "(==== bun ====)" + "\n" + "= filling ingredient =" + "\n" + "(==== bun ====)" + "\n\n" + "Price: 400,000000" + "\n";
        String reciept = burger.getReceipt();
        System.out.println(expected);
        System.out.println(reciept);
        assertTrue(expected.contains("= filling ingredient ="));
    }
}