package praktikum.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Ingredient mockIngredient;

    private int initialSize;
    private int expectedSize;
    private int indexToRemove;
    private int newIndexToMove;
    private int expectedIndexAfterMove;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0, 0, 0, 0, 0}, // Нулевой список, ничего не делаем
                {1, 0, 0, 0, 0, 0}, // Список из одного элемента, ничего не делаем
                {3, 2, 1, 1, 1, 1}, // Удаляем элемент с индексом 1, ожидаем размер 2
                {3, 3, 1, 2, 1, 2}  // Перемещаем элемент с индекса 1 на индекс 2, размер остается 3
        });
    }

    public BurgerTest(int initialSize, int expectedSize, int indexToRemove, int newIndexToMove, int expectedIndexAfterMove) {
        this.initialSize = initialSize;
        this.expectedSize = expectedSize;
        this.indexToRemove = indexToRemove;
        this.newIndexToMove = newIndexToMove;
        this.expectedIndexAfterMove = expectedIndexAfterMove;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        // Заполним список ингредиентов предварительно
        for (int i = 0; i < initialSize; i++) {
            burger.ingredients.add(mock(Ingredient.class));
        }
    }

    @Test
    public void testAddIngredient() {
        List<Ingredient> ingredients = burger.ingredients;

        // Добавляем мок-ингредиент
        burger.addIngredient(mockIngredient);

        // Проверяем, что ингредиент был добавлен
        assertEquals(expectedSize, ingredients.size());

        // Проверяем, что метод getPrice будет вызван на мок-ингредиенте, когда будет вызываться getPrice на бургере
        burger.getPrice();
        verify(mockIngredient, times(1)).getPrice();
    }

    @Test
    public void testRemoveIngredient() {
        List<Ingredient> ingredients = burger.ingredients;

        // Удаляем ингредиент
        burger.removeIngredient(indexToRemove);

        // Проверяем, что ингредиент был удален
        assertEquals(expectedSize, ingredients.size());

        // Проверяем, что метод getPrice будет вызван на мок-ингредиенте, когда будет вызываться getPrice на бургере
        burger.getPrice();
        verify(mockIngredient, times(1)).getPrice();
    }

    @Test
    public void testMoveIngredient() {
        List<Ingredient> ingredients = burger.ingredients;

        // Запомним ингредиент перед перемещением
        Ingredient ingredientToMove = ingredients.get(indexToRemove);

        // Перемещаем ингредиент
        burger.moveIngredient(indexToRemove, newIndexToMove);

        // Проверяем, что ингредиент был перемещен на правильную позицию
        assertEquals(expectedIndexAfterMove, ingredients.indexOf(ingredientToMove));

        // Проверяем, что метод getPrice будет вызван на мок-ингредиенте, когда будет вызываться getPrice на бургере
        burger.getPrice();
        verify(mockIngredient, times(1)).getPrice();
    }
}
