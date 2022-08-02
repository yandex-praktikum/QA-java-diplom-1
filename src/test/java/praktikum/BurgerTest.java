package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    String bunName = "Французская булочка";
    float bunPrice = 7.77F;
    String ingredientName = "Чесночный соус";
    float ingredientPrice = 3.33F;
    Burger burger;
    Ingredient firstIngredient = mock(Ingredient.class);
    Ingredient secondIngredient = mock(Ingredient.class);
    Bun bun = mock(Bun.class);

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void checkSettingTheBun() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        String actualBunName = burger.bun.getName();
        assertEquals("Имя булочки не задано", actualBunName, bunName);
    }

    @Test
    public void checkOfAddTheIngredient() {
        burger.addIngredient(firstIngredient);
        assertFalse("Игредиент не добавлен", burger.ingredients.isEmpty());
    }

    @Test
    public void checkOfRemoveTheIngredient() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertTrue("Ингредиент не удален", burger.ingredients.isEmpty());
    }

    @Test
    public void checkOfMoveTheIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиент не перемещен", burger.ingredients.indexOf(firstIngredient), 1);
    }

    @Test
    public void checkGetOfPriceTheBurger() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(firstIngredient.getPrice()).thenReturn(ingredientPrice);
        float correctPrice = bunPrice * 2 + ingredientPrice;
        assertEquals("Некорректная цена", burger.getPrice(), correctPrice, 0);
    }

    @Test
    public void checkTheFormatOfTheBurgerReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(firstIngredient.getName()).thenReturn(ingredientName);
        Mockito.when(firstIngredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        String expectedFormat =
                String.format("(==== %s ====)%n", bunName) +
                        String.format("= %s %s =%n", firstIngredient.getType().toString().toLowerCase(), ingredientName) +
                        String.format("(==== %s ====)%n", bunName) +
                        String.format("%nPrice: %f%n", (bunPrice * 2 + ingredientPrice));
        assertEquals("Некорректный формат", expectedFormat, burger.getReceipt());
    }
}
