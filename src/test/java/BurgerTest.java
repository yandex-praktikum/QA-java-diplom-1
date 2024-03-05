import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.Burger;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Test
    public void getPriceSingeIngredient() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(1.0f);
        burger.setBuns(bun);
        Mockito.when(ingredient1.getPrice()).thenReturn(2.0f);
        burger.addIngredient(ingredient1);
        assertEquals(4.0f, burger.getPrice(), 0.01f);
    }
    @Test
    public void getPriceMultipleIngredients() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(1.0f);
        burger.setBuns(bun);
        Mockito.when(ingredient1.getPrice()).thenReturn(2.0f);
        burger.addIngredient(ingredient1);
        Mockito.when(ingredient2.getPrice()).thenReturn(3.0f);
        burger.addIngredient(ingredient2);
        assertEquals(7.0f, burger.getPrice(), 0.01f);
    }
    @Test
    public void getReceiptOneIngredientTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(bun.getPrice()).thenReturn(1.0f);
        burger.setBuns(bun);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("Cheese");
        Mockito.when(ingredient1.getPrice()).thenReturn(2.0f);
        burger.addIngredient(ingredient1);
        assertEquals("(==== Bun ====)\r\n= filling Cheese =\r\n(==== Bun ====)\r\n\r\nPrice: 4,000000\r\n", burger.getReceipt());
    }
    @Test
    public void getReceiptAfterRemovingIngredientTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(bun.getPrice()).thenReturn(1.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals("(==== Bun ====)\r\n(==== Bun ====)\r\n\r\nPrice: 2,000000\r\n", burger.getReceipt());
    }
    @Test
    public void getReceiptAfterMovingIngredientTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(bun.getPrice()).thenReturn(1.0f);
        burger.setBuns(bun);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("Cheese");
        Mockito.when(ingredient1.getPrice()).thenReturn(2.0f);
        burger.addIngredient(ingredient1);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("Tomato");
        Mockito.when(ingredient2.getPrice()).thenReturn(3.0f);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("(==== Bun ====)\r\n= filling Tomato =\r\n= filling Cheese =\r\n(==== Bun ====)\r\n\r\nPrice: 7,000000\r\n", burger.getReceipt());
    }
}
