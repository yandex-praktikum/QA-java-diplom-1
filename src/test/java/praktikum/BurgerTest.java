package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

// Я не прибегал к параметризации, потому что посчитал, что в коде отсутствует логика, на которую бы влияли изменения параметров.
// 1. Все методы только присваивают и возвращают значения, которые поступают на вход. Их я и проверяю.
// 2. Различные значения enum-а IngredientType тоже ни на что не влияют.
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    // Мок двух ингредиентов для проверки их добавления в список
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient secondIngredient;

    // Тест выбора булочки
    // Тест заключается в сравнении параметров выбранной булочки с заранее известными значениями
    @Test
    public void setBunsSetsBunCorrectly() {
        Burger burger = new Burger();

        String expectedBunName = "black bun";
        float expectedBunPrice = 100;

        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn((float) 100);

        // Используются методы публичной переменной класса Burger
        String realBunName = burger.bun.getName();
        float realBunPrice = burger.bun.getPrice();

        Assert.assertEquals("Должно быть присвоено ожидаемое значение названия булочки", expectedBunName, realBunName);
        Assert.assertEquals("Должно быть присвоено ожидаемое значение цены булочки", expectedBunPrice, realBunPrice, 0);
    }

    // Тест добавления ингредиента в список
    // Тест заключается в сравнении параметров добавленного ингредиента с заранее известными значениями
    // и проверки длины получившегося списка
    @Test
    public void addIngredientAddsIngredientCorrectly() {
        Burger burger = new Burger();

        IngredientType expectedIngredientType = IngredientType.SAUCE;
        String expectedIngredientName = "hot sauce";
        float expectedIngredientPrice = 200;
        int expectedIngredientsSize = 1;

        burger.addIngredient(ingredient);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn((float) 200);

        // Используются методы публичной переменной класса Ingredient
        IngredientType realIngredientType = burger.ingredients.get(0).getType();
        String realIngredientName = burger.ingredients.get(0).getName();
        float realIngredientPrice = burger.ingredients.get(0).getPrice();
        // Берется длина публичного списка List<Ingredient>
        int realIngredientsSize = burger.ingredients.size();

        Assert.assertEquals("Должно быть присвоено ожидаемое значение типа ингредиента", expectedIngredientType, realIngredientType);
        Assert.assertEquals("Должно быть присвоено ожидаемое значение названия ингредиента", expectedIngredientName, realIngredientName);
        Assert.assertEquals("Должно быть присвоено ожидаемое значение цены ингредиента", expectedIngredientPrice, realIngredientPrice, 0);
        Assert.assertEquals("Список должен состоять из 1 элемента", expectedIngredientsSize, realIngredientsSize);
    }

    // Тест удаления ингредиента из списка
    // Тест заключается в добавлении ингредиента, последующего его удаления и проверки длины списка
    @Test
    public void removeIngredientRemovesIngredientCorrectly() {
        Burger burger = new Burger();

        int expectedIngredientsSize = 0;

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        // Берется длина публичного списка List<Ingredient>
        int realIngredientsSize = burger.ingredients.size();

        Assert.assertEquals("Список должен быть пустым", expectedIngredientsSize, realIngredientsSize);
    }

    // Тест замены местами ингредиентов
    // Тест заключается в добавлении двух ингредиентов, последующего замены их местами
    // и сравнении их параметров с заранее известными значениями
    @Test
    public void moveIngredientChangesIngredientPlaces() {
        Burger burger = new Burger();

        IngredientType expectedFirstIngredientType = IngredientType.FILLING;
        String expectedFirstIngredientName = "cutlet";
        float expectedFirstIngredientPrice = 400;
        IngredientType expectedSecondIngredientType = IngredientType.SAUCE;
        String expectedSecondIngredientName = "hot sauce";
        float expectedSecondIngredientPrice = 200;

        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0,1);

        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("cutlet");
        Mockito.when(secondIngredient.getPrice()).thenReturn((float) 400);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn((float) 200);

        // Используются методы публичной переменной класса Ingredient
        IngredientType realFirstIngredientType = burger.ingredients.get(0).getType();
        String realFirstIngredientName = burger.ingredients.get(0).getName();
        float realFirstIngredientPrice = burger.ingredients.get(0).getPrice();

        IngredientType realSecondIngredientType = burger.ingredients.get(1).getType();
        String realSecondIngredientName = burger.ingredients.get(1).getName();
        float realSecondIngredientPrice = burger.ingredients.get(1).getPrice();

        Assert.assertEquals("Тип первого ингредиента в списке должно соответствовать второму добавленному ингредиента", expectedFirstIngredientType, realFirstIngredientType);
        Assert.assertEquals("Название первого ингредиента в списке должно соответствовать второму добавленному ингредиента", expectedFirstIngredientName, realFirstIngredientName);
        Assert.assertEquals("Цена первого ингредиента в списке должно соответствовать второму добавленному ингредиента", expectedFirstIngredientPrice, realFirstIngredientPrice, 0);

        Assert.assertEquals("Тип второго ингредиента в списке должно соответствовать второму добавленному ингредиента", expectedSecondIngredientType, realSecondIngredientType);
        Assert.assertEquals("Название второго ингредиента в списке должно соответствовать второму добавленному ингредиента", expectedSecondIngredientName, realSecondIngredientName);
        Assert.assertEquals("Цена второго ингредиента в списке должно соответствовать второму добавленному ингредиента", expectedSecondIngredientPrice, realSecondIngredientPrice, 0);
    }

    // Тест получения цены бургера
    // Тест заключается в выборе булочки, добавлении двух ингредиентов, получения цены
    // и сравнении е с заранее известным значением
    @Test
    public void getPriceReturnsPrice() {
        Burger burger = new Burger();

        float expectedBurgerPrice = 800;

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);

        Mockito.when(bun.getPrice()).thenReturn((float) 100);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 200);
        Mockito.when(secondIngredient.getPrice()).thenReturn((float) 400);

        float realBurgerPrice = burger.getPrice();

        Assert.assertEquals("Цена должна соответствовать ожидаемому результату", expectedBurgerPrice, realBurgerPrice,0);
    }

    // Тест получения рецепта бургера
    // Тест заключается в выборе булочки, добавлении двух ингредиентов, получения рецепта
    // и сравнении е с заранее известным значением
    @Test
    public void getReceiptReturnsReceipt() {
        Burger burger = new Burger();

        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append(String.format("(==== black bun ====)%n"));
        receiptBuilder.append(String.format("= sauce hot sauce =%n"));
        receiptBuilder.append(String.format("= filling cutlet =%n"));
        receiptBuilder.append(String.format("(==== black bun ====)%n"));
        receiptBuilder.append(String.format("%nPrice: 800,000000%n"));
        String expectedReceipt = receiptBuilder.toString();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn((float) 100);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn((float) 200);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("cutlet");
        Mockito.when(secondIngredient.getPrice()).thenReturn((float) 400);

        String realReceipt = burger.getReceipt();

        Assert.assertEquals("Рецепт должна соответствовать ожидаемому результату", expectedReceipt, realReceipt);
    }
}
