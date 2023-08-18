import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;


import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn((float)30);
        Mockito.when(ingredient.getPrice()).thenReturn((float)20);
        assertEquals((float) 80, burger.getPrice(), 0.00);
}

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("black bun");
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn((float)30);
        Mockito.when(ingredient.getPrice()).thenReturn((float)20);
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== black bun ====)\n" +
                "= sauce sour cream =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 80,000000%n"));
        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
