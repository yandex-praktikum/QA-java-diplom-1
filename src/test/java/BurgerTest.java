import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun whiteBun;
    @Mock
    Ingredient cutlet;
    @Mock
    Ingredient chiliSauce;

    @Test // Готовим булку. Проверяем наличие булки.
    public void setBunsAndCheckDone() {
        Burger burger = new Burger();
        burger.setBuns(whiteBun);
        assertThat("Булка не приготовилась!", burger.bun, is(notNullValue()));
    }

    @Test // Добавляем ингредиент. Проверяем, что добавленный ингредиент содержится в бургере.
    public void addIngredientAndCheckContains() {
        Burger burger = new Burger();
        burger.addIngredient(cutlet);
        assertThat("Ингредиент не добавлен!", burger.ingredients.contains(cutlet));
    }

    @Test // Удаляем ингредиент. Проверяем, что ингредиент удален.
    public void removeIngredientAndCheckIsEmpty() {
        Burger burger = new Burger();
        burger.addIngredient(chiliSauce);
        burger.removeIngredient(0);
        assertThat("Ингредиент не удален!",burger.ingredients.isEmpty());
    }

    @Test // Меняем местами ингредиенты. Проверяем, что ингредиенты поменялись местами.
    public void moveIngredientAndCheckMoving() {
        Burger burger = new Burger();
        burger.addIngredient(cutlet);
        burger.addIngredient(chiliSauce);
        List<Ingredient> ingredient = new ArrayList<>();
        ingredient.add(chiliSauce);
        ingredient.add(cutlet);
        burger.moveIngredient(0,1);
        Assert.assertEquals("Ингредиенты не поменяны местами!", burger.ingredients, ingredient);
    }

    @Test // Создаем бургер из булки и нескольких ингредиентов и вычисляем цену. Проверяем, что цена корректна.
    public void getPriceAndCheckIsCorrectPrice() {
        Burger burger = new Burger();
        burger.setBuns(whiteBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(chiliSauce);
        Mockito.when(whiteBun.getPrice()).thenReturn(200f);
        Mockito.when(cutlet.getPrice()).thenReturn(100f);
        Mockito.when(chiliSauce.getPrice()).thenReturn(300f);
        Assert.assertEquals("Цена бургера некорректна!", burger.getPrice(), 800, 1);
    }

    @Test // Создаем бургер. Мокируем названия, типы и цены ингредиентов. Печатаем чек, проверяем, что он корректен.
    public void getReceiptAndCheckIsCorrectReceipt() {
        Burger burger = new Burger();
        burger.setBuns(whiteBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(chiliSauce);
        Mockito.when(whiteBun.getName()).thenReturn("white bun");
        Mockito.when(cutlet.getName()).thenReturn("cutlet");
        Mockito.when(chiliSauce.getName()).thenReturn("chili sauce");
        Mockito.when(chiliSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(whiteBun.getPrice()).thenReturn(100f);
        Mockito.when(cutlet.getPrice()).thenReturn(100f);
        Mockito.when(chiliSauce.getPrice()).thenReturn(300f);

        String expectedResult =
                "(==== white bun ====)\r\n" +
                "= filling cutlet =\r\n" +
                "= sauce chili sauce =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 600,000000\r\n";

        Assert.assertEquals("Проблемы с чеком!", expectedResult, burger.getReceipt());
    }
}
