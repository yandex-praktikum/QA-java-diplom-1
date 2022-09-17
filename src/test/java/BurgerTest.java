import jdk.jfr.Description;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Spy
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    @DisplayName("SetBuns test")
    @Description("Тестирование сеттера")
    public void setBunsTest() {
        burger.setBuns(bun);
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(2)).setBuns(bun);
    }

    @Test
    @DisplayName("Add ingredient test")
    @Description("Тестирование метода, добавляющего ингредиенты в ArrayList")
    public void addIngredientTest() {
        burger.addIngredient(new Database().availableIngredients().get(0));
        int actual = burger.ingredients.size();
        assertEquals(1, actual);
    }

    @Test
    @DisplayName("Remove ingredient test")
    @Description("Тестирование метода, удаляющего ингредиенты из ArrayList")
    public void removeIngredientTest() {
        burger.ingredients.add(new Database().availableIngredients().get(0));
        burger.ingredients.add(new Database().availableIngredients().get(1));
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        assertEquals(1, actual);
    }

    @Test
    @DisplayName("Move ingredient Test")
    @Description("Тестирование метода, перемещающего ингредиенты в ArrayList")
    public void moveIngredientTest() {
        burger.ingredients.add(new Database().availableIngredients().get(0));
        burger.ingredients.add(new Database().availableIngredients().get(1));
        Object expected = burger.ingredients.get(1);
        burger.ingredients.add(new Database().availableIngredients().get(2));
        burger.ingredients.add(new Database().availableIngredients().get(3));
        burger.moveIngredient(1, 3);
        Object actual = burger.ingredients.get(3);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get receipt test")
    @Description("Тестирование метода, возвращающего рецепт")
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(burger.getPrice()).thenReturn(300f);
        String expected = "(==== black bun ====)\n= filling cutlet =\n(==== black bun ====)\n\nPrice: 300,000000\n";
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}
