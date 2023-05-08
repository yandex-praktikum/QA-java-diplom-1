import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;
    @Mock
    Ingredient ingredientMock2;
    private Burger burger = new Burger();

    @Test
    public void setBunsTest() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientMock);
        assertEquals(List.of(ingredientMock), burger.ingredients);
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        assertEquals(List.of(), burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        burger.moveIngredient(1, 0);
        assertEquals(ingredientMock, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.ingredients = List.of(ingredientMock);
        burger.setBuns(bunMock);
        Mockito.when(bunMock.getPrice()).thenReturn(2f);
        Mockito.when(ingredientMock.getPrice()).thenReturn(2f);
        float expectedPrice = 6f;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        String actualReceipt = "(==== Булочка ====)\r\n" +
                "= sauce Сырный =\r\n" +
                "(==== Булочка ====)\r\n" +
                "\r\n" +
                "Price: 9,000000" +
                "\r\n";
        burger.setBuns(bunMock);
        burger.ingredients = List.of(ingredientMock);
        Mockito.when(bunMock.getName()).thenReturn("Булочка");
        Mockito.when(bunMock.getPrice()).thenReturn(2f);
        Mockito.when(ingredientMock.getName()).thenReturn("Сырный");
        Mockito.when(ingredientMock.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientMock.getPrice()).thenReturn(5f);
        assertEquals(actualReceipt, burger.getReceipt());
    }
}
