package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    Bun mockBun;
    @Mock
    Ingredient salad;
    @Mock
    Ingredient cheese;


    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(salad);
        burger.addIngredient(cheese);
    }

    @Test
    public void setBuns_ShouldSetBun() {
        burger.setBuns(mockBun);
        assertEquals("Булочка не установлена", mockBun, burger.bun);
    }

    @Test
    public void addIngredient_ShouldAddIngredient() {
        burger.addIngredient(salad);
        assertTrue("Ингредиент не добавился", burger.ingredients.contains(salad));
    }

    @Test
    public void removeIngredient_ShouldRemoveIngredient_AndChangeIngredientsSize() {
        int index = 1;
        Ingredient ingredientToRemove = burger.ingredients.get(index);
        int size = burger.ingredients.size();
        burger.removeIngredient(index);
        assertFalse("Ингредиент не удалился", burger.ingredients.contains(ingredientToRemove));
        assertEquals("Неправильное кол-во ингредиентов", size - 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredient_ShouldSwapIngredients() {
        int index = 0;
        int newIndex = 1;
        Ingredient ingredientToMove = burger.ingredients.get(index);
        int size = burger.ingredients.size();

        burger.moveIngredient(index, newIndex);
        assertEquals("Ингредиенты не поменялись", ingredientToMove, burger.ingredients.get(newIndex));
        assertEquals("Ингредиенты не поменялись", size, burger.ingredients.size());
    }

    @Test
    public void getPrice_ZeroDelta_ShouldReturnPrice() {
        float bunPrice = 5.0f;
        when(mockBun.getPrice()).thenReturn(bunPrice);

        float saladPrice = 1.0f;
        when(salad.getPrice()).thenReturn(saladPrice);

        float cheesePrice = 2.0f;
        when(cheese.getPrice()).thenReturn(cheesePrice);

        float expectedPrice = bunPrice * 2 + saladPrice + cheesePrice;
        float actualPrice = burger.getPrice();
        assertEquals("Цена бургера не совпадает", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceipt_ShouldReturn_EqualReceipt() {
        when(mockBun.getName()).thenReturn("Булочка");
        when(mockBun.getPrice()).thenReturn(2.0f);

        when(salad.getType()).thenReturn(IngredientType.SAUCE);
        when(salad.getName()).thenReturn("Салат");

        when(cheese.getType()).thenReturn(IngredientType.FILLING);
        when(cheese.getName()).thenReturn("Сыр");

          String expectedReceipt = "(==== Булочка ====)\r\n" +
                  "= sauce Салат =\r\n" +
                  "= filling Сыр =\r\n" +
                  "(==== Булочка ====)\r\n" +
                  "\r\n" +
                  "Price: 4,000000\r\n";
        System.out.println(expectedReceipt);

        assertEquals("Информация о бургере не совапдает",expectedReceipt, burger.getReceipt());
    }
}

