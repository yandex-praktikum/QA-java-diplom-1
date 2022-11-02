package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Юнит-тесты класса Burger
 * (кроме сеттера)
 */
@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientTest {
    // Инициализируем базу данных
    Database database = new Database();

    // Считаем список доступных булок из базы данных
    List<Bun> buns = database.availableBuns();

    // Считаем список доступных ингредиентов из базы данных
    List<Ingredient> ingredients = database.availableIngredients();

    // Создаем бургер
    Burger burger = new Burger();

    // Объявляем объекты классов которые будут использоваться в юнит-тестах
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient anotherIngredient;

    // Описываем действия которые будут происходить перед каждым тестом
    @Before
    public void createBurger() {
        // Создаем случайные значения индексов для получения тестовых данных из БД
        int bunIndex = new Random().nextInt(buns.size());
        int ingredientIndex = new Random().nextInt(ingredients.size());

        // Создаем тестовые данные используя значения из базы данных
        this.ingredient = ingredients.get(ingredientIndex);
        this.bun = buns.get(bunIndex);

        // Добавляем к бургеру булку
        burger.setBuns(bun);
    }

    // Проверяем что добавленный ингредиент попадает в бургер (отобразится в составе)
    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        assertThat(burger.getReceipt(), containsString(ingredient.getName()));
    }

    // Проверяем что удаленный ингредиент не попадает в бургер (не отобразится в составе)
    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertThat(burger.getReceipt(), not(containsString((ingredient.getName()))));
    }

    // Проверяем что перемещенный слой с ингредиентом будет отображаться на новом месте
    // (перемещаем ингредиент с первого места на последнее и проверяем что в составе
    // бургера он теперь отображается на последнем месте)
    @Test
    public void checkMoveIngredient() {
        this.anotherIngredient = ingredients.get(new Random().nextInt(ingredients.size()));
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(0, 1);
        // Название перемещенного ингредиента должно отображаться в составе последними, перед нижней булкой
        assertThat(burger.getReceipt(), containsString(String.format("%s =%n(", ingredient.getName())));
    }

    // Проверяем что можно получить корректную цену бургера, если есть и булка и ингредиент
    @Test
    public void checkGetPriceWithIngredient() {
        burger.addIngredient(ingredient);
        // Цена равна сумме цен 2 шт булок и 1 шт ингредиента
        assertEquals(bun.getPrice() * 2 + ingredient.getPrice(), burger.getPrice(), 0);
    }

    // Проверяем что можно получить корректную цену бургера, если есть только булка
    @Test
    // Цена равна сумме цен 2 шт булок
    public void checkGetPriceWithoutIngredient() {
        assertEquals(bun.getPrice() * 2, burger.getPrice(), 0);
    }

    // Проверяем что состав бургера отображается корректно, если есть и булка и ингредиент
    @Test
    public void checkGetReceiptWithIngredient() {
        burger.addIngredient(ingredient);
        // Состав заканчивается корректной ценой бургера, округленной до 6 знаков после запятой
        assertThat(burger.getReceipt(), endsWith(String.format("%.6f%n", bun.getPrice() * 2 + ingredient.getPrice())));
    }

    // Проверяем что состав бургера отображается корректно, если есть только булка
    @Test
    public void checkGetReceiptWithoutIngredient() {
        assertThat(burger.getReceipt(), endsWith(String.format("%.6f%n", bun.getPrice() * 2)));
    }
}
