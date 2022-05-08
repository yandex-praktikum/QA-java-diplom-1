package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    String bunName = "Star Burgs";
    float bunPrice = 88.99F;
    String ingredientName = "Yodanez";
    float ingredientPrice = 15.70F;

    Burger burger;

    @Mock
    private Ingredient firstIngredient;
    @Mock
    private Ingredient secondIngredient;
    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
    }


    @Test
    public void checkSettingBun() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        String actual = burger.bun.getName();
        assertEquals(bunName, actual);
    }


    @Test
    public void checkToEmptyIngredient() {
        burger.addIngredient(firstIngredient);
        assertFalse("Ингредиет не добавлен", burger.ingredients.isEmpty());
    }


    @Test
    public void checkToDeleteIngredient() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertTrue("Ингридиент не удален", burger.ingredients.isEmpty());
    }

    @Test
    public void checkToMoveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1, 0);
        assertEquals("The ingredient has not been moved!", burger.ingredients.indexOf(firstIngredient), 1);
    }

    @Test
    public void checkGetOfPriceBurger() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(firstIngredient.getPrice()).thenReturn(ingredientPrice);
        float correctPrice = bunPrice * 2 + ingredientPrice;
        assertEquals("Не правильная цена", burger.getPrice(), correctPrice, 0);
    }

    //Проверяем формат чека бургера
    @Test
    public void checkFormatOfBurgerReceipt() {
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
        assertEquals("Не правильный чек", expectedFormat, burger.getReceipt());
    }
}