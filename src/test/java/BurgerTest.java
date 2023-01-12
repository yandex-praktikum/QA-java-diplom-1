import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun mockBun;
    @Mock
    Ingredient mockIngredient;

    @Before
    public void init() {
        burger = new Burger();
    }

    @Test
    public void checkAddIngredient() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);

        int ingredientSize = burger.ingredients.size();
        boolean actual = ingredientSize > 0;

        assertTrue("В собранном бургере отсутсвуют ингридиенты, добавь хотябы 1", actual);
    }

    @Test
    public void checkGetValidPrice() {
        Mockito.when(mockBun.getPrice()).thenReturn(101.5f);
        Mockito.when(mockIngredient.getPrice()).thenReturn(100.5f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        Float actual = burger.getPrice();
        Float expected = 303.5f;

        assertEquals("Цена не совпала с ожидаемой", expected, actual, 0.01f);
    }


    @Test
    public void checkDeleteIngredients() {

        Ingredient ingredient_0 = new Ingredient(SAUCE, "hot sauce", 100);
        Ingredient ingredient_1 = new Ingredient(SAUCE, "sour cream", 200);
        Ingredient ingredient_2 = new Ingredient(SAUCE, "chili sauce", 300);
        burger.addIngredient(ingredient_0);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        burger.removeIngredient(0);
        int ingredientSize = burger.ingredients.size();

        assertEquals("Кол-во ингридиентов не соответсвует", 2, ingredientSize);
    }

    @Test
    public void checkMoveIngredients() {

        Ingredient ingredient_0 = new Ingredient(SAUCE, "hot sauce", 100);
        Ingredient ingredient_1 = new Ingredient(SAUCE, "sour cream", 200);
        Ingredient ingredient_2 = new Ingredient(SAUCE, "chili sauce", 300);
        burger.addIngredient(ingredient_0);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        burger.moveIngredient(0, 1);
        burger.moveIngredient(0, 2);
        burger.moveIngredient(1, 2);
        int index_0 = burger.ingredients.indexOf(ingredient_0);
        int index_1 = burger.ingredients.indexOf(ingredient_1);
        int index_2 = burger.ingredients.indexOf(ingredient_2);

        assertNotEquals(index_0, index_1);
        assertNotEquals(index_0, index_2);
        assertNotEquals(index_1, index_2);
    }

    @Test
    public void checkGetValidReceipt() {

        Mockito.when(mockIngredient.getName()).thenReturn("cutlet");
        Mockito.when(mockIngredient.getType()).thenReturn(FILLING);
        Mockito.when(mockIngredient.getPrice()).thenReturn(100f);
        burger.addIngredient(mockIngredient);

        Mockito.when(mockBun.getName()).thenReturn("black bun");
        Mockito.when(mockBun.getPrice()).thenReturn(100F);
        burger.setBuns(mockBun);

        StringBuilder expected = new StringBuilder();
        expected.append(String.format("(==== %s ====)%n", mockBun.getName()));
        expected.append(String.format("= %s %s =%n", burger.ingredients.get(0).getType().toString().toLowerCase(),
                burger.ingredients.get(0).getName()));

        expected.append(String.format("(==== %s ====)%n", "black bun"));
        expected.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String expectedReceipt = expected.toString();
        String actual = burger.getReceipt();

        assertEquals(expectedReceipt, actual);
    }

}
