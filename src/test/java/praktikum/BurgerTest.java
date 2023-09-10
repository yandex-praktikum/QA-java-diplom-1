package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Spy
    private Bun bun;  // Инициализация шпиона при объявлении
    @Spy
    private Ingredient ingredient1;  // Инициализация шпиона при объявлении
    @Spy
    private Ingredient ingredient2;  // Инициализация шпиона при объявлении

    @Mock
    private Database database;

    private Burger burger;
    private List<Bun> buns;
    private List<Ingredient> ingredients;

    @Before
    public void setUp() {
        // Создадим фейковые списки для булок и ингредиентов
        List<Bun> mockBuns = Arrays.asList(
                new Bun("black bun", 100),
                new Bun("white bun", 200),
                new Bun("red bun", 300)
        );
        List<Ingredient> mockIngredients = Arrays.asList(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
                new Ingredient(IngredientType.FILLING, "cutlet", 100),
                new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                new Ingredient(IngredientType.FILLING, "sausage", 300)
        );
        // Настраиваем поведение mock-объекта базы
        Mockito.when(database.availableBuns()).thenReturn(mockBuns);
        Mockito.when(database.availableIngredients()).thenReturn(mockIngredients);
        // Создаем новый бургер
        burger = new Burger();
        // Получимаем список доступных булок
        buns = database.availableBuns();
        // Получаем список доступных ингредиентов
        ingredients = database.availableIngredients();
        burger = new Burger();
    }

    @Test
    public void getPriceTest() {
        // Устанавливаем булки и ингредиенты для бургера
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        //Настраиваем поведение mock объектов
        Mockito.when(bun.getPrice()).thenReturn(buns.get(0).getPrice());
        Mockito.when(ingredient1.getPrice()).thenReturn(ingredients.get(0).getPrice());
        Mockito.when(ingredient2.getPrice()).thenReturn(ingredients.get(1).getPrice());

        // Вызываем метод для рассчета стоимости бургера
        float actualPrice = burger.getPrice();

        // Проверяем, что методы были вызваны
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient1, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient2, Mockito.times(1)).getPrice();

        // Рассчитываем ожидаемую цену
        float expectedPrice = 100.0F * 2 + (100.0F + 200.0F);

        // Проверяем, что цена соответствует ожидаемой
        assertEquals(expectedPrice, actualPrice, 0.001);
    }


    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Настраиваем шпионы с желаемым поведением
        Mockito.when(bun.getName()).thenReturn(buns.get(0).getName());
        Mockito.when(bun.getPrice()).thenReturn(buns.get(0).getPrice());
        Mockito.when(ingredient1.getName()).thenReturn(ingredients.get(0).getName());
        Mockito.when(ingredient1.getType()).thenReturn(ingredients.get(0).getType());
        Mockito.when(ingredient1.getPrice()).thenReturn(ingredients.get(0).getPrice());
        Mockito.when(ingredient2.getName()).thenReturn(ingredients.get(3).getName());
        Mockito.when(ingredient2.getType()).thenReturn(ingredients.get(3).getType());
        Mockito.when(ingredient2.getPrice()).thenReturn(ingredients.get(3).getPrice());

        // Генерируем ожидаемый чек
        String expectedReceipt =
                "(==== black bun ====)\r\n" +
                        "= sauce hot sauce =\r\n" +
                        "= filling cutlet =\r\n" +
                        "(==== black bun ====)\r\n" +
                        "\r\n" +
                        "Price: 400,000000\r\n";

        // Генерируем фактический чек
        String actualReceipt = burger.getReceipt();
        // Проверяем, что методы были вызваны в теле getReceipt()
        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(ingredient1, Mockito.times(1)).getName();
        Mockito.verify(ingredient1, Mockito.times(1)).getType();
        Mockito.verify(ingredient2, Mockito.times(1)).getName();
        Mockito.verify(ingredient2, Mockito.times(1)).getType();

        //Сравниваем ожидаемый и фактический чек
        assertThat(actualReceipt, equalTo(expectedReceipt));
    }
}