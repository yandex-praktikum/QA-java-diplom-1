package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

import org.junit.Before;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient Sauce;
    @Mock
    private Ingredient Filling;

    @Before
    public void createNewBurger() {
        burger = new Burger();
    }


    @Test
    public void setBurgerBunsTest() {
        burger.setBuns(bun);
        assertNotNull("Неверное значение", burger.bun);
    }

    @Test
    public void addBurgerIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals("Неверное количиство значений в списке ингредиентов", 1, burger.ingredients.size());
    }

    @Test
    public void removeBurgerIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Неверное количиство значений в списке ингредиентов",0, burger.ingredients.size());
    }

    @Test
    public void moveBurgerIngredientTest() {
        burger.addIngredient(Sauce);
        burger.addIngredient(Filling);
        burger.moveIngredient(0, 1);
        assertEquals("Неверное перемещение значений в списке ингредиентов", Sauce, burger.ingredients.get(1));
    }

    @Test
    public void getBurgerPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(100.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals("Неверное значение цены",200.0f * 2 + 100.0f, burger.getPrice(), 0);
    }

    @Test
    public void getBurgerReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100.0f);
        burger.addIngredient(ingredient);
        String expected = "(==== white bun ====)" + "\r\n" + "= filling cutlet =" + "\r\n" + "(==== white bun ====)" + "\r\n" + "\r\n" + "Price: 500,000000\r\n";
        assertEquals("Неправильный рецепт", expected, burger.getReceipt());
    }

}

