package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient, secondIngredient;

    @Test
    public void setBunsSetsBunsToBurger() {
        // Arrange
        Burger burger = new Burger();
        // Act
        burger.setBuns(bun);
        // Assert
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientAddsIngredientToBurger() {
        // Arrange
        Burger burger = new Burger();
        // Act
        burger.addIngredient(firstIngredient);
        // Assert
        Assert.assertEquals(firstIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientRemovesIngredientFromBurger(){
        // Arrange
        Burger burger = new Burger();
        // Act
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        // Assert
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientMovesIngredientFromBurger() {
        // Arrange
        Burger burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        int expectedIndex = 1;
        // Act
        burger.moveIngredient(0,1);
        // Assert
        Assert.assertEquals(expectedIndex, burger.ingredients.lastIndexOf(firstIngredient));
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        // Arrange
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        float expectedPrice = 7000.0f;
        // Act
        Mockito.when(bun.getPrice()).thenReturn(1255.0f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(90.0f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(4400.0f);
        // Assert
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptReturnsCorrectString() {
        // Arrange
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String expectedReceipt = "(==== Краторная булка N-200i ====)\n= sauce Соус Spicy-X =\n= filling Биокотлета из марсианской Магнолии =\n(==== Краторная булка N-200i ====)\n\nPrice: 2490,000000\n";
        // Act
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(988.0f);
        Mockito.when(firstIngredient.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(firstIngredient.getPrice()).thenReturn(90.0f);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngredient.getName()).thenReturn("Биокотлета из марсианской Магнолии");
        Mockito.when(secondIngredient.getPrice()).thenReturn(424.0f);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(988.0f);
        // Assert
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

}