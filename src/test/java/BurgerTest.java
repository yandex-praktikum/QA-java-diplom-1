import org.junit.Test;
import org.apache.commons.lang3.RandomStringUtils;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    private Ingredient ingredient;

    private int index;
    private int expectedSize;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    public BurgerTest(int index, int expectedSize) {
        this.index = index;
        this.expectedSize = expectedSize;
    }

    /*
    Проверка метода setBuns() класса Burger.java
    Мок сдесь не нужен, т.к. проверка идет самого создаваемого объекта внутри тестируемого класса
     */
    @Test
    public void testSetBunsSomeBunReturnBun() throws Exception {
        String name = RandomStringUtils.randomAlphabetic(10);

        Random random = new Random();
        Float price = random.nextFloat();

        Bun bun = new Bun(name, price);

        Burger burger = new Burger();
        burger.setBuns(bun);

        Bun expectedBun = burger.bun;

        assertEquals("Error in Burger class setBuns() method", expectedBun, bun);
    }

    /*
    Проверка метода addIngredient() класса Burger.java
    Мок сдесь не нужен, т.к. проверка идет самого создаваемой переменной внутри тестируемого класса
     */
    @Test
    public void testAddIngredientSomeBunReturnList() throws Exception {

        Random random = new Random();
        List<Ingredient> expectedIigredient = List.of(
                new Ingredient(IngredientType.FILLING, RandomStringUtils.randomAlphabetic(10), random.nextFloat()*100),
                new Ingredient(IngredientType.SAUCE, RandomStringUtils.randomAlphabetic(10), random.nextFloat()*100));

        Burger burger = new Burger();
        for (Ingredient ingredient : expectedIigredient) {
            burger.addIngredient(ingredient);
        }

        List<Ingredient> actualIigredient = burger.ingredients;

        assertEquals("Error in Burger class addIngredient() method", expectedIigredient, actualIigredient);

    }

    @Parameterized.Parameters (name = "Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][] {
                { 0, 1},
                { 1, 1},
        };
    }

    /*
    Проверка метода removeIngredient() класса Burger.java
    Параметризированный тест, без мока
    */
    @Test
    public void testRemoveIngredientParameterized() {
        Random random = new Random();
        List<Ingredient> expectedIigredient = List.of(
                new Ingredient(IngredientType.FILLING, RandomStringUtils.randomAlphabetic(10), random.nextFloat()*100),
                new Ingredient(IngredientType.SAUCE, RandomStringUtils.randomAlphabetic(10), random.nextFloat()*100));

        Burger burger = new Burger();
        for (Ingredient ingredient : expectedIigredient) {
            burger.addIngredient(ingredient);
        }

        burger.removeIngredient(index);

        int actualSize = burger.ingredients.size();

        assertEquals("Error in Burger class removeIngredient() method",expectedSize, actualSize);
    }

    /*
    Проверка метода getPrice() класса Burger.java
    Использован мок на классе Bun и Ingredient на методе getPrice(), всегда возвращает 500F
    */
    @Test
    public void testGetPriceSomeBurgerReturnFloat() throws Exception {

        Mockito.when(bun.getPrice()).thenReturn(300F);
        Mockito.when(ingredient.getPrice()).thenReturn(500F);

        float expectedPrice = 2 * 300F;

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        expectedPrice = expectedPrice + ingredient.getPrice();

        float actualPrice = burger.getPrice();

        assertEquals("Error in Burger class getPrice() method", expectedPrice, actualPrice, 0);

    }

    /*
    Проверка метода getReceipt() класса Burger.java
    Использован мок на классе Bun, на методе getPrice(), всегда возвращает 500F
    Использован мок на классе Bun, на методе getName(), всегда возвращает "some_bun"
    Использован мок на классе Bun, на методе getType(), всегда возвращает FILLING
    Использован мок на классе Ingredient, на методе getName(), всегда возвращает some_ingredient
    Использован мок на классе Ingredient, на методе getPrice(), всегда возвращает 700F
    */
    @Test
    public void testGetReceiptSomeBurgerReturnString() throws Exception {

        Mockito.when(bun.getPrice()).thenReturn(500F);
        Mockito.when(bun.getName()).thenReturn("some_bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("some_ingredient");
        Mockito.when(ingredient.getPrice()).thenReturn(700F);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== " + bun.getName() + " ====)\r\n"
                + "= " + ingredient.getType().toString().toLowerCase()
                + " " +  ingredient.getName() + " =\r\n"
                + "(==== " + bun.getName() + " ====)\r\n"
                + "\r\nPrice: " + String.format("%.6f", 2 * bun.getPrice() + ingredient.getPrice()) + "\r\n";

        assertEquals("Error in Burger class getReceipt() method", expectedReceipt, burger.getReceipt());

    }

}
