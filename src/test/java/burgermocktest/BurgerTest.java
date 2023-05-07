package burgermocktest;

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

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(40F);
        burger.setBuns(bun);
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        float sum = bun.getPrice() * 2 + firstIngredient.price + secondIngredient.price;
        assertEquals("Ошибка стоимомсти бургера", sum, burger.getPrice(),0.0);
    }

    @Mock
    Bun tel;
    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Mockito.when(tel.getName()).thenReturn("black bun");
        Mockito.when(tel.getPrice()).thenReturn(40F);
        burger.setBuns(tel);
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String expectedReceipt = burger.getReceipt();
        assertEquals("Ошибка полученного ожидаемого рецепта", expectedReceipt, burger.getReceipt());
    }

    @Mock
    Burger burger;
    @Test
    public void removeIngredientTest() {
    burger.removeIngredient(0);
    Mockito.verify(burger).removeIngredient(0);
    }
    @Mock
    Burger ingredient;
    @Test
    public void moveIngredientTest() {
        ingredient.moveIngredient(1,2);
        Mockito.verify(ingredient).moveIngredient(1,2);
    }
}
