package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);

        int expectedSize = 1;
        int actualSize = burger.ingredients.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        int expectedSize = 0;
        int actualSize = burger.ingredients.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void moveIngredientTest() {

        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "creamOne", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "creamTwo", 300));

        burger.moveIngredient(0, 1);

        String expectedName = "creamOne";
        String actualName = burger.ingredients.get(1).name;

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceTest() {

        float price = 100;

        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expectedPrice = price * 2 + price;
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.01);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("newBun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("newSouse");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== newBun ====)\r\n= sauce newSouse =\r\n(==== newBun ====)\r\n\r\nPrice: 500,000000\r\n";
        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }

}