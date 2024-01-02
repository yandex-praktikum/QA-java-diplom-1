package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    @InjectMocks
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        // Инициализация моков для теста
        burger = new Burger();
        ingredient1 = Mockito.mock(Ingredient.class);
        ingredient2 = Mockito.mock(Ingredient.class);
        bun = Mockito.mock(Bun.class);
    }

    // Тест проверяет метод setBuns, который устанавливает булочку бургера
    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        // Проверка, что булочка установлена правильно
        assertEquals(bun, burger.bun);
    }

    // Тест проверяет метод addIngredient, который добавляет ингредиент в бургер
    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        // Проверка, что ингредиент добавлен в список ингредиентов бургера
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    // Тест проверяет метод removeIngredient, который удаляет ингредиент из бургера
    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        // Проверка, что ингредиент удален из списка ингредиентов бургера
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    // Тест проверяет метод moveIngredient, который перемещает ингредиент в бургере
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        // Проверка, что ингредиенты перемещены в нужном порядке
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }
}
