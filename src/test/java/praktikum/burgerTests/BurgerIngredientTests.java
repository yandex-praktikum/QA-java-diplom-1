package praktikum.burgerTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientTests {


    private final Ingredient ingredientMock1 = mock(Ingredient.class);
    private final Ingredient ingredientMock2 = mock(Ingredient.class);
    private final Ingredient ingredientMock3 = mock(Ingredient.class);

    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientOneItemShowsItemAdded() {
        burger.addIngredient(ingredientMock1);

        int expectedListSize = 1;
        int actualListSize = burger.ingredients.size();

        assertEquals("Ожидается длина списка 1", expectedListSize, actualListSize);
        assertThat(burger.ingredients, hasItem(ingredientMock1));

    }

    @Test
    public void addIngredientSeveralItemsShowsItemsAdded() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        int expectedListSize = 2;
        int actualListSize = burger.ingredients.size();

        assertEquals("Ожидается длина списка больше 1", expectedListSize, actualListSize);
        assertThat("Ожидается, что в списке есть ингридиенты 1 и 2", burger.ingredients, hasItems(ingredientMock1, ingredientMock2));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIngredientEmptyListResultException() {
        burger.removeIngredient(0);

    }

    @Test
    public void removeIngredientOneItemListResultListEmpty() {
        burger.addIngredient(ingredientMock1);
        burger.removeIngredient(0);

        assertTrue("Ожидается пустой список", burger.ingredients.isEmpty());

    }

    @Test
    public void removeIngredientListResultItemRemoved() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.removeIngredient(1);

        int expectedListSize = 1;
        int actualListSize = burger.ingredients.size();

        assertEquals("Ожидается длина списка 1", expectedListSize, actualListSize);
        assertThat("Ожидается, что из списка удален только 2 игридиент", burger.ingredients, not(hasItem(ingredientMock2)));

    }


    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.moveIngredient(2, 0);

        int expectedListSize = 3;
        int actualListSize = burger.ingredients.size();

        assertEquals("Ожидается, что длина списка не изменилась", expectedListSize, actualListSize);
        assertEquals("Ожидается, что ингридиент №3 перемещен в начало списка", burger.ingredients.get(0), ingredientMock3);

    }

}
