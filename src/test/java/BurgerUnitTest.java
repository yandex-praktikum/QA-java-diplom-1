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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerUnitTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    private final double delta = 0;
    @Mock
    private Ingredient secondIngredient;


    @Test
    public void addIngredientWithCorrectParameter() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        Ingredient expectedResult = firstIngredient;
        assertEquals("List is incorrect", expectedResult, burger.ingredients.get(0));
    }


    @Test
    public void removeIngredientCheck() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        List<Ingredient> expectedResult = new ArrayList<>();
        assertEquals("List is incorrect", expectedResult, burger.ingredients);
    }


    @Test
    public void moveIngredientWithCorrectParameter() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("Ingredient is incorrect", firstIngredient, burger.ingredients.get(1));
    }


    @Test
    public void getPriceReturnsCorrectValue() {
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(firstIngredient.getPrice()).thenReturn(50F);
        Mockito.when(secondIngredient.getPrice()).thenReturn(100F);
        float expectedResult = 550F;
        float actualResult = burger.getPrice();
        assertEquals("Total price is incorrect", expectedResult, actualResult, delta);
    }


    @Test
    public void getReceiptReturnsCorrectValues() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getName()).thenReturn("Сдобная");
        Mockito.when(firstIngredient.getName()).thenReturn("Курица");
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        String expectedReceipt = burger.getReceipt();
        assertTrue("The burger receipt should have the bun name", expectedReceipt.contains("Сдобная"));
        assertTrue("The burger receipt should have the ingredient name", expectedReceipt.contains("Курица"));
        assertTrue("The burger receipt should have the price field", expectedReceipt.contains("Price"));
    }

}