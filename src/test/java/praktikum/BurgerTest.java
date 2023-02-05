package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Database database = new Database();
    Burger burger;
    int sizeOfIngredients;

    @Before
    public void setUp() {
        burger = new Burger();
        for(int i = 0; i <= 5; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }

        sizeOfIngredients = burger.ingredients.size();
    }

    @Mock
    Bun bun;
    Ingredient ingredient = mock(Ingredient.class);

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);

        assertNotNull("Бургер пустой", burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals("Неверное количество ингредиентов", 7, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(1);
        assertEquals("Неверное количество ингредиентов", 5, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredientBefore = burger.ingredients.get(1);
        burger.moveIngredient(1, 0);
        Ingredient ingredientAfter = burger.ingredients.get(0);
        assertEquals("Ингредиенты не поменялись местами", ingredientAfter, ingredientBefore);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(400f);
        float actualPrice = bun.getPrice();

        assertEquals("Неверное отображение цены", 400f, actualPrice, 0.0f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        List<Ingredient> ingredientList = new ArrayList<>(burger.ingredients);
        Mockito.when(bun.getName()).thenReturn("Булочка");

        assertEquals("Некорректное отображение чека", "(==== " + bun.getName() + " ====)\r\n" +
                "= sauce " + ingredientList.get(0).getName() + " =\r\n" +
                "= sauce " + ingredientList.get(1).getName() + " =\r\n" +
                "= sauce " + ingredientList.get(2).getName() + " =\r\n" +
                "= filling " + ingredientList.get(3).getName() + " =\r\n" +
                "= filling " + ingredientList.get(4).getName() + " =\r\n" +
                "= filling " + ingredientList.get(5).getName() + " =\r\n" +
                "(==== " + bun.getName() + " ====)\r\n" + "\r\n" +
                "Price: 1200,000000\r\n", burger.getReceipt());
    }
}
