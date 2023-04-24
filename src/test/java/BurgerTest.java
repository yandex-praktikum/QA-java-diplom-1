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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredientSauce;

    @Mock
    private Ingredient ingredientFilling;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Bun actualBun = burger.bun;
        assertEquals("Неправильная булка в бургере", bun, actualBun);

    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredientSauce);
        List<Ingredient> actualIngredients = burger.ingredients;
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(ingredientSauce);
        assertEquals("Ингредиенты не совпадают", expectedIngredients, actualIngredients);
    }

    @Test
    public void shouldRemoveExistIngredient() {
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        int actualSize = burger.ingredients.size();
        assertEquals("список ингредиентов должен быть пустым", 0, actualSize);
    }

    @Test
    public void shouldMoveExistingIngredients() {
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0, 1);
        Ingredient actualIngredient = burger.ingredients.get(1);
        assertEquals("Ингредиенты не совпадают", ingredientSauce, actualIngredient);
    }

    @Test
    public void shouldReturnCorrectReceipt() {
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200f);
        burger.setBuns(bun);

        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn("sour cream");
        Mockito.when(ingredientSauce.getPrice()).thenReturn(200f);
        burger.addIngredient(ingredientSauce);

        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFilling.getName()).thenReturn("sausage");
        Mockito.when(ingredientFilling.getPrice()).thenReturn(300f);
        burger.addIngredient(ingredientFilling);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("рецепт некорректный", receipt.toString(), burger.getReceipt());
    }
}
