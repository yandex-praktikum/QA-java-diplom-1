package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient cheese;
    @Mock
    List<Ingredient> ingredients;
    @Mock
    Bun bun;
    @Mock
    Ingredient cutlet;
    @Mock
    Ingredient ketchup;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals("Булочка должна быть поставлена", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue("Список ингридиентов содержит ингридиент", burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        Mockito.when(ingredients.remove(1)).thenReturn(ingredient);
        burger.ingredients = ingredients;
        burger.removeIngredient(1);
        Mockito.verify(burger.ingredients).remove(1);
    }

    @Test
    public void moveIngredientTest() {

        int index = 1;
        int newIndex = 2;

        burger.ingredients = ingredients;
        burger.moveIngredient(index, newIndex);
        Mockito.verify(burger.ingredients).add(newIndex, ingredients.remove(index));
        Mockito.verify(burger.ingredients).remove(index);
    }

    @Test
    public void getPriceTest() {
        burger.addIngredient(ingredient);
        float ingredientsSum = bun.getPrice() * 2 + ingredient.getPrice() + cheese.getPrice();
        burger.setBuns(bun);
        assertEquals("Цена неверная", ingredientsSum,
                burger.getPrice(), 00);
    }

    @Test
    public void getReceiptTest() {
        burger = new Burger();
        burger.addIngredient(cheese);
        burger.addIngredient(cutlet);
        burger.addIngredient(ketchup);

        Mockito.when(bun.getPrice()).thenReturn(1.5f);
        Mockito.when(cheese.getPrice()).thenReturn(2.0f);
        Mockito.when(cutlet.getPrice()).thenReturn(3.0f);
        Mockito.when(ketchup.getPrice()).thenReturn(0.5f);

        Mockito.when(bun.getName()).thenReturn("КосмоБулка");
        Mockito.when(cheese.getName()).thenReturn("КосмоСыр");
        Mockito.when(cutlet.getName()).thenReturn("КосмоКотлета");
        Mockito.when(ketchup.getName()).thenReturn("КосмоКетчуп");

        Mockito.when(cheese.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ketchup.getType()).thenReturn(IngredientType.SAUCE);

        String expectedReceipt = "(==== КосмоБулка ====)\r\n" +
                "= filling КосмоСыр =\r\n" +
                "= filling КосмоКотлета =\r\n" +
                "= sauce КосмоКетчуп =\r\n" +
                "(==== КосмоБулка ====)\r\n" +
                "\r\n" +
                "Price: 8,500000\r\n";

        burger.setBuns(bun);
        Assert.assertEquals("Не получен ожидаемый рецепт", expectedReceipt, burger.getReceipt());
    }
}
