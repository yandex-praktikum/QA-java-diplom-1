package praktikum.burger_tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientTest {
    private final Ingredient ingredientMock1 = mock(Ingredient.class);
    private final Ingredient ingredientMock2 = mock(Ingredient.class);
    private final Ingredient ingredientMock3 = mock(Ingredient.class);
    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientWhenOneItemResultOneItemAdded() {
        burger.addIngredient(ingredientMock1);

        int expectedListSize = 1;
        int actualListSize = burger.ingredients.size();

        assertThat("Ожидается длина списка 1", expectedListSize, equalTo(actualListSize));
        assertThat(burger.ingredients, hasItem(ingredientMock1));
    }

    @Test
    public void addIngredientWhenSeveralItemsShowsAllItemsAdded() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);

        int expectedListSize = 3;
        int actualListSize = burger.ingredients.size();

        assertThat("Ожидается длина списка больше 1", expectedListSize, equalTo(actualListSize));
        assertThat("Ожидается, что в списке есть ингридиенты 1, 2, 3", burger.ingredients, hasItems(ingredientMock1, ingredientMock2, ingredientMock3));
    }

    @Test
    public void addIngredientWhenSameItemAddedTwiceShowsListWithTwoItems() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock1);

        int expectedListSize = 2;
        int actualListSize = burger.ingredients.size();

        assertThat("Ожидается длина списка больше 1", expectedListSize, equalTo(actualListSize));
        assertThat("Ожидается, что в списке есть 2 ингридиента №1", burger.ingredients, hasItems(ingredientMock1, ingredientMock1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIngredientEmptyListResultException() {
        burger.removeIngredient(0);
    }

    @Test
    public void removeIngredientOneItemListResultListEmpty() {
        burger.addIngredient(ingredientMock1);
        burger.removeIngredient(0);

        assertThat("Ожидается пустой список", burger.ingredients.isEmpty(), is(true));
    }

    @Test
    public void removeIngredientListResultItemRemoved() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.removeIngredient(1);

        int expectedListSize = 1;
        int actualListSize = burger.ingredients.size();

        assertThat("Ожидается длина списка 1", expectedListSize, equalTo(actualListSize));
        assertThat("Ожидается, что из списка удален только 2 игридиент", burger.ingredients, not(hasItem(ingredientMock2)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIngredientWhenMissingItemExpectedException() {
        burger.addIngredient(ingredientMock1);
        burger.removeIngredient(1);
    }

    @Test
    public void moveIngredientResultItemsChangedPosition() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.moveIngredient(2, 0);

        int expectedListSize = 3;
        int actualListSize = burger.ingredients.size();

        assertEquals("Ожидается, что длина списка не изменилась", expectedListSize, actualListSize);
        assertEquals("Ожидается, что ингридиент №3 перемещен в начало списка", burger.ingredients.get(0), ingredientMock3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void moveIngredientWhenMissingItemExpectedException() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.moveIngredient(2, 0);
    }

}
