import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Ingredient ingredient;
    private Burger burger;
    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();

        burger.setBuns(bun);

        ingredient = new Ingredient(IngredientType.начинка, "Хорошо", 5);
        burger.addIngredient(ingredient);
    }

    @Test
    public void correctBunsTest() {
        Mockito.when(burger.bun.getName()).thenReturn("Хорошо");
        assertEquals("Элемент добавлен", "Хорошо", burger.bun.getName());
    }

    @Test
    public void incorrectBunsTest() {
        Mockito.when(burger.bun.getName()).thenReturn("Плохо");
        assertEquals("Элемент не добавлен", "Плохо", burger.bun.getName());
    }

    @Test
    public void incorrectIngredientTest() {
        assertFalse("Элемент не добавлен", burger.ingredients.isEmpty());
    }

    @Test
    public void incorrectRemoveIngredient() {
        burger.removeIngredient(0);

        assertTrue("Элемент не удален", burger.ingredients.isEmpty());
    }

    @Test
    public void correctMoveIngredientTest() {
        ingredient = new Ingredient(IngredientType.начинка, "Хорошо", 5);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        assertEquals("Элемент перемещен", "Хорошо", burger.ingredients.get(0).name);
    }

    @Test
    public void incorrectMoveIngredientTest() {
        ingredient = new Ingredient(IngredientType.соус, "Плохо", 10);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        assertEquals("Элемент не перемещен", "Плохо", burger.ingredients.get(0).name);
    }

    @Test
    public void getReceipt() {
        Mockito.when(burger.bun.getName()).thenReturn("булочка");

        StringBuilder receipt = new StringBuilder(String.format("(%s)%n", burger.bun.getName()));

        for (Ingredient ingredient : burger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(%s)%n", burger.bun.getName()));
        Mockito.when(burger.bun.getPrice()).thenReturn(50);
        receipt.append(String.format("%nЦена: %f%n", burger.getPrice()));

        assertEquals(burger.getReceipt(), receipt.toString());
    }
}