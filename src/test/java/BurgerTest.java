import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;
import praktikum.*;
import static org.junit.Assert.*;

public class BurgerTest {
    Burger burger;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient secondIngredient;


    @Test
    public void checkBunIsSet() {
        burger.setBuns(bun);
        Bun result = burger.bun;
        assertEquals("Значение переменной bun не сооветствует", bun, result);
    }

    @Test
    public void checkIngredientIsAdded() {
        burger.addIngredient(ingredient);
        Boolean result = burger.ingredients.contains(ingredient);
        assertEquals("Добавленный ингридиент не был добавлен", true, result);
    }

    @Test
    public void checkIngredientIsRemoved() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Boolean result = burger.ingredients.contains(ingredient);
        assertEquals("Добавленный ингридиент не был удалён", false, result);
    }

    @Test
    public void checkIngredientIsMoved() {
        burger.addIngredient(secondIngredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        Ingredient result = burger.ingredients.get(0);
        assertEquals("Ингридиент не был перемещён на нужный индекс", ingredient, result);
    }

    @Test
    public void checkCorrectPriceIsReturned() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(bun.getPrice()).thenReturn(0.5f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(2f);
        float result = burger.getPrice();
        assertEquals(4f, result,0);
    }

    @Test
    public void checkCorrectReceiptIsReturned() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(bun.getName()).thenReturn("bunName");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("ingredientName");
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("secondIngredientName");
        Mockito.when(burger.getPrice()).thenReturn(1f);
        String result = burger.getReceipt();
        String expectedResult = String.format(
                "(==== %s ====)%n"
                + "= %s %s =%n"
                + "= %s %s =%n"
                + "(==== %s ====)%n"
                +  "%nPrice: %f%n",
                "bunName", "sauce","ingredientName", "filling","secondIngredientName", "bunName", 1f);
        assertEquals(expectedResult, result);
    }
}