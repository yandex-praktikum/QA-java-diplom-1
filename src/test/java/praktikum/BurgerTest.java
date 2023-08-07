package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Burger burgerStub;
    @Spy
    Database database;
    @Spy
    Burger burger;

    @Before
    public void setUpBurgerData(){
        //добавляем в bun данные из базы данных
        burger.setBuns(database.availableBuns().get(0));
        //добавляем в список ingredients все данные из базы данных
        burger.ingredients.addAll(database.availableIngredients());
    }
    @Test
    public void addIngredientTest() {
        //создание переменной класса Ingredient, которую мы добавим в список
        Ingredient newIngredient = new Ingredient(IngredientType.FILLING, "sosiska", 500);
        burger.addIngredient(newIngredient);
        int ingredientsSize = burger.ingredients.size();
        //проверяем что метод addIngredient() сработал верно и в конец добавилось то что нужно
        Assert.assertEquals(newIngredient, burger.ingredients.get(ingredientsSize - 1));
    }

    @Test
    public void removeIngredientTest() {
        //сохраняем первый элемент списка для дальнейших проверок
        Ingredient ingredientsToDelete = burger.ingredients.get(0);
        burger.removeIngredient(0);
        //проверяем что после метода removeIngredient() в нашем списке нет элемента, который мы сохранили раньше
        Assert.assertFalse(burger.ingredients.contains(ingredientsToDelete));
    }

    @Test
    public void moveIngredientTest() {

        burger.moveIngredient(0, 1);
        //Так как метод moveIngredient() просто меняет местами переменные,
        //то мы просто првоеряем что все элементы остались в этом спсике
        Assert.assertTrue(burger.ingredients.containsAll(database.availableIngredients()));
    }

    @Test
    public void getPriceTest() {
        //Задаём свою логику в метод getPrice() класса Burger при помощи стаба
        Mockito.when(burgerStub.getPrice()).thenReturn(166F);
        Assert.assertEquals(166, burgerStub.getPrice(), 0);
    }

    @Test
    public void getReceiptTitleTest() {
        //Сохраним изначальное название булочки первой переменной из базы данных
        String title = database.availableBuns().get(0).getName();
        //Проверка что в хедере чека действительно находится наша булочка
        Assert.assertTrue(burger.getReceipt().startsWith(String.format("(==== %s ====)", title)));

    }

    @Test
    public void getReceiptBodyTest() {
        //Проверка что в теле чека действительно находятся все ингридиенты
        for (Ingredient item : burger.ingredients) {
            MatcherAssert.assertThat(burger.getReceipt(),allOf(
                    containsString(item.getName()),
                    containsString(item.getType().toString().toLowerCase())
                    ));
        }
    }
    @Test
    public void getReceiptPriceTest(){
        //Сохраним сумму всего бургера для дальнейших проверок
        float price=burger.getPrice();
        //Проверка что в цонце чека действительно нахоится верная сумма
        Assert.assertTrue(burger.getReceipt().endsWith(String.format("%nPrice: %f%n", price)));
    }
}