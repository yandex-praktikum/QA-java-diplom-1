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
    private final static int INDEX = 0;
    private final static int NEW_INDEX = 1;
    private final static float EXPECTED_PRICE = 300;
    private final static String EXPECTED_RECEIPT = "(==== Обыкновенная булочка ====)\r\n" +
            "= sauce Огуречный =\r\n" +
            "= sauce Огуречный =\r\n" +
            "(==== Обыкновенная булочка ====)\r\n" +
            "\r\n" +
            "Price: 400,000000\r\n";

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;


    @Test
    public void setNewBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(burger.bun, bun);
    }

    @Test
    public void addIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.size(), 1);
    }

    @Test
    public void removeIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(INDEX);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientsInList() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(INDEX, NEW_INDEX);
        assertEquals(burger.ingredients.get(NEW_INDEX), burger.ingredients.get(INDEX));
    }

    @Test
    public void getBurgerTotalPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float actualPrice = burger.getPrice();
        assertEquals(EXPECTED_PRICE, actualPrice, 0.05);
    }

    @Test
    public void getBurgerReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Обыкновенная булочка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Огуречный");
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        String actualReceipt = burger.getReceipt();
        assertEquals(EXPECTED_RECEIPT, actualReceipt);
    }
}
