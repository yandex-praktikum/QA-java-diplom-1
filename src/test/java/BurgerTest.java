import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

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
    @Spy
    Burger burger = new Burger();


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        burger.ingredients.add(cheese);
        burger.ingredients.add(cutlet);

        Mockito.when(bun.getPrice()).thenReturn(1.5f);
        Mockito.when(cheese.getPrice()).thenReturn(2.0f);
        Mockito.when(cutlet.getPrice()).thenReturn(3.0f);

        Mockito.when(bun.getName()).thenReturn("КосмоБулка");
        Mockito.when(cheese.getName()).thenReturn("КосмоСыр");
        Mockito.when(cutlet.getName()).thenReturn("КосмоКотлета");

        Mockito.when(cheese.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);

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
        Assert.assertEquals("Ожидалось, что в списке будет 3 ингредиента", 3, burger.ingredients.size());
    }

    @Test
    public void removeIngredientDecreaseListSize() {
        burger.removeIngredient(0);
        Assert.assertEquals("Ожидалось, что в списке будет 1 ингредиента", 1, burger.ingredients.size());
        Assert.assertFalse("Ожидалось, что в списке нет сыра", burger.ingredients.contains(cheese));
    }

    @Test
    public void moveIngredientChangeIngredientIndex() {
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ожидалось, что индекс сыра станет = 1",
                1, burger.ingredients.indexOf(cheese));
    }

    @Test
    public void getPriceReturnSumOfAllIngredients() {
        float ingredientsSum = bun.getPrice() * 2 + cheese.getPrice() + cutlet.getPrice();
        burger.setBuns(bun);
        Assert.assertEquals("Цена неверная", ingredientsSum,
                burger.getPrice(),0.01F);
    }

    @Test
    public void getReceiptReturnAllIngredientsString() {
        burger.setBuns(bun);
        String expectedReceipt = "(==== КосмоБулка ====)\r\n" +
                "= filling КосмоСыр =\r\n" +
                "= filling КосмоКотлета =\r\n" +
                "(==== КосмоБулка ====)\r\n" +
                "\r\n" +
                "Price: 8,000000\r\n";

        Mockito.when(burger.getPrice()).thenReturn(8F);
        
        Assert.assertEquals("Не получен ожидаемый рецепт", expectedReceipt, burger.getReceipt());

        Mockito.verify(cheese, Mockito.times(1)).getType();
        Mockito.verify(cheese, Mockito.times(1)).getName();
        Mockito.verify(cutlet, Mockito.times(1)).getType();
        Mockito.verify(cutlet, Mockito.times(1)).getName();
        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(burger, Mockito.times(1)).getPrice();

    }
}