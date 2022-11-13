import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import constants.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient cutlet;
    @Mock
    Ingredient mayonnaise;
    @Mock
    Ingredient ketchup;

    Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
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
    }

    @After
    public void shutdown() {
        burger.bun = null;
        burger.ingredients.clear();
    }

    @Test
    public void setBunsSetBunNotNull() {
        burger.setBuns(bun);
        Assert.assertNotNull("Ожидалось, что будет добавлена булочка", burger.bun);
    }

    @Test
    public void addIngredientAddIngredientToList() {
        burger.addIngredient(mayonnaise);
        Assert.assertEquals("Ожидалось, что в списке будет 4 ингредиента", 4, burger.ingredients.size());
    }

    @Test
    public void removeIngredientDecreaseListSize() {
        burger.removeIngredient(0);
        Assert.assertEquals("Ожидалось, что в списке будет 2 ингредиента", 2, burger.ingredients.size());
        Assert.assertFalse("Ожидалось, что в списке нет сыра", burger.ingredients.contains(cheese));
    }

    @Test
    public void moveIngredientChangeIngredientIndex() {
        burger.moveIngredient(0, 2);
        Assert.assertEquals("Ожидалось, что индекс сыра станет = 2",
                2, burger.ingredients.indexOf(cheese));
    }

    @Test
    public void getPriceReturnSumOfAllIngredients() {
        float ingredientsSum = bun.getPrice() * 2 + cheese.getPrice() + cutlet.getPrice() + ketchup.getPrice();
        burger.setBuns(bun);
        Assert.assertEquals("Цена неверная", ingredientsSum,
                burger.getPrice(), Constants.FLOAT_DELTA);
    }

    @Test
    public void getReceiptReturnAllIngredientsString() {
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
