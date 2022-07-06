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

    //Переменные для тестов
    String bunName = "тестовая булка";
    float bunPrice = 6.66F;
    String ingredientName = "тестовый соус";
    float ingredientPrice = 7.77F;
    //Объекты для теста
    Burger burger;
    Ingredient firstIngredient = mock(Ingredient.class);
    Ingredient secondIngredient = mock(Ingredient.class);
    Bun bun = mock(Bun.class);

    @Before
    public void setUp() {
        burger = new Burger();
    }

    //Проверяем, что можно указать булку для бургера
    @Test
    public void checkSettingTheBun() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        String actual = burger.bun.getName();
        assertEquals("The bun name is not set!", actual, bunName);
    }

    //Проверяем, что можно добавить ингредиент в бургер
    @Test
    public void checkOfAddingTheIngredient() {
        burger.addIngredient(firstIngredient);
        assertFalse("The ingredient was not added!", burger.ingredients.isEmpty());
    }

    //Проверяем, что ингредиент можно убрать из бургера
    @Test
    public void checkOfRemovingTheIngredient() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertTrue("The ingredient was not removed!", burger.ingredients.isEmpty());
    }

    //Проверяем, что ингредиенты бургера можно менять местами в списке
    @Test
    public void checkOfMovingTheIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1, 0);
        assertEquals("The ingredient has not been moved!", burger.ingredients.indexOf(firstIngredient), 1);
    }

    //Проверяем, что после выбора булки и ингредиента цена бургера !=0
    @Test
    public void checkGetOfPriceTheBurger() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(firstIngredient.getPrice()).thenReturn(ingredientPrice);
        float correctPrice = bunPrice * 2 + ingredientPrice;
        assertEquals("Incorrect price!", burger.getPrice(), correctPrice, 0);
    }

    //Проверяем формат чека бургера
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
        assertEquals("Incorrect receipt format!", expectedFormat, burger.getReceipt());
    }
}