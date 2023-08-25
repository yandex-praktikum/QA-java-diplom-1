import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient, secondIngredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(new ArrayList<>(Arrays.asList(secondIngredient, firstIngredient)), burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getPrice()).thenReturn((float) 30);
        Mockito.when(firstIngredient.getPrice()).thenReturn((float) 20);
        assertEquals((float) 80, burger.getPrice(), 0.00);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("black bun");
        burger.addIngredient(firstIngredient);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("sour cream");
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn((float) 30);
        Mockito.when(firstIngredient.getPrice()).thenReturn((float) 20);
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== black bun ====)\n" +
                "= sauce sour cream =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 80,000000%n"));
        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
