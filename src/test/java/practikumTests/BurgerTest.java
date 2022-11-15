package practikumTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static testData.TestConstants.DELTA;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient marsSauce;
    @Mock
    Ingredient venusCheese;
    @Mock
    Ingredient moonSalad;
    @Mock
    Ingredient sunBeef;
    @Mock
    Ingredient saturnOnion;

    Burger burger;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.addIngredient(marsSauce);
        burger.addIngredient(moonSalad);
        burger.addIngredient(sunBeef);
        burger.addIngredient(venusCheese);

        Mockito.when(bun.getName()).thenReturn("Булка обыкновенная");
        Mockito.when(marsSauce.getName()).thenReturn("Марсианский соус");
        Mockito.when(moonSalad.getName()).thenReturn("Лунный салат");
        Mockito.when(sunBeef.getName()).thenReturn("Мясо из жителей солнца");
        Mockito.when(venusCheese.getName()).thenReturn("Сыр с венеры");

        Mockito.when(bun.getPrice()).thenReturn(12.55f);
        Mockito.when(marsSauce.getPrice()).thenReturn(7.3f);
        Mockito.when(moonSalad.getPrice()).thenReturn(9.12f);
        Mockito.when(sunBeef.getPrice()).thenReturn(23.1f);
        Mockito.when(venusCheese.getPrice()).thenReturn(5.3f);

        Mockito.when(marsSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(moonSalad.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(sunBeef.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(venusCheese.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void setBunTest(){
        burger.setBuns(bun);
        Assert.assertNotNull("Булка не добавлена", burger.bun);
    }

    @Test
    public void quantityOfIngredientsWithAddIngredientTest(){
        burger.addIngredient(saturnOnion);
        Assert.assertEquals("Должно было быть 5 ингредиентов ", 5, burger.ingredients.size());
    }

    @Test
    public void quantityOfIngredientsWithRemoveIngredientTest(){
        burger.removeIngredient(1);
        Assert.assertEquals("Должно было быть 3 ингредиента", 3, burger.ingredients.size());
    }

    @Test
    public void changesIngredientIndexWithMoveIngredientTest(){
        burger.moveIngredient(1,2);
        Assert.assertEquals("Индекс лунного салата должен был быть = 2", 2, burger.ingredients.indexOf(moonSalad));
    }

    @Test
    public void getPriceForAllIngredientsTest(){
        float price = bun.getPrice()*2 + marsSauce.getPrice() + moonSalad.getPrice() + sunBeef.getPrice() + venusCheese.getPrice();
        burger.setBuns(bun);
        Assert.assertEquals("Неправильный подсчет", price, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptReturnsIngredientsList(){
        String receipt = "(==== Булка обыкновенная ====)\r\n" +
                "= sauce Марсианский соус =\r\n" +
                "= filling Лунный салат =\r\n" +
                "= filling Мясо из жителей солнца =\r\n" +
                "= filling Сыр с венеры =\r\n" +
                "(==== Булка обыкновенная ====)\r\n" +
                "\r\n" +
                "Price: 69,920006\r\n";
        burger.setBuns(bun);
        Assert.assertEquals("Рецепт не совпадает", receipt, burger.getReceipt());
    }

    @After
    public void deleteBurg() {
        burger.ingredients.clear();
        burger.bun = null;
    }
}
