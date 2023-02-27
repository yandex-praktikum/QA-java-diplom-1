import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    public String generateRandomName() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public float generateRandomPrice() {
        int min = 0;
        int max = 100;
        Random r = new Random();
        return min + r.nextFloat() * (max - min);
    }

    public IngredientType generateRandomIngredientType() {
        List<IngredientType> givenList = Arrays.asList(IngredientType.SAUCE, IngredientType.FILLING);
        Random r = new Random();
        return givenList.get(r.nextInt(givenList.size()));
    }

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockIngredient1;

    @Mock
    Ingredient mockIngredient2;

    @Mock
    Ingredient mockIngredient3;

    @Before
    public void initialize() {
        burger = new Burger();
    }

    @Test
    public void setBunsCorrectlyAddBuns() {
        mockBun.name = generateRandomName();
        mockBun.price = generateRandomPrice();
        burger.setBuns(mockBun);
        Assert.assertEquals("Неверная работа метода setBuns", mockBun, burger.bun);
    }

    @Test
    public void addIngredientCorrectlyAddingAnIngredient() {
        mockIngredient1.name = generateRandomName();
        mockIngredient1.price = generateRandomPrice();
        mockIngredient1.type = generateRandomIngredientType();
        burger.addIngredient(mockIngredient1);
        Assert.assertEquals("Неверная работа метода addIngredient", mockIngredient1, burger.ingredients.get(burger.ingredients.size()-1));
    }

    @Test
    public void removeIngredientCorrectlyRemovingAnIngredient() {
        mockIngredient1.name = generateRandomName();
        mockIngredient1.price = generateRandomPrice();
        mockIngredient1.type = generateRandomIngredientType();
        burger.ingredients.add(mockIngredient1);
        burger.removeIngredient(burger.ingredients.indexOf(mockIngredient1));
        Assert.assertEquals("Неверная работа метода removeIngredient", false, burger.ingredients.contains(mockIngredient1));
    }

    @Test
    public void moveIngredientCorrectlyMoveSelectedIngredient() {
        int initialIndex = 2;
        int resultingIndex = 0;
        mockIngredient1.name = generateRandomName();
        mockIngredient1.price = generateRandomPrice();
        mockIngredient1.type = generateRandomIngredientType();
        mockIngredient2.name = generateRandomName();
        mockIngredient2.price = generateRandomPrice();
        mockIngredient2.type = generateRandomIngredientType();
        mockIngredient3.name = generateRandomName();
        mockIngredient3.price = generateRandomPrice();
        mockIngredient3.type = generateRandomIngredientType();
        burger.ingredients.add(mockIngredient1);
        burger.ingredients.add(mockIngredient2);
        burger.ingredients.add(mockIngredient3);
        List<Ingredient> expectedListofIngredients = new ArrayList<>();
        expectedListofIngredients.add(mockIngredient3);
        expectedListofIngredients.add(mockIngredient1);
        expectedListofIngredients.add(mockIngredient2);
        burger.moveIngredient(initialIndex,resultingIndex);
        Assert.assertEquals("Неверная работа метода removeIngredient", expectedListofIngredients, burger.ingredients);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        // генерируем цены для моков
        mockBun.price = generateRandomPrice();
        mockIngredient1.price = generateRandomPrice();
        mockIngredient2.price = generateRandomPrice();
        mockIngredient3.price = generateRandomPrice();

        // задаем методы моков
        Mockito.when(mockBun.getPrice()).thenReturn(mockBun.price);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(mockIngredient1.price);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(mockIngredient2.price);
        Mockito.when(mockIngredient3.getPrice()).thenReturn(mockIngredient3.price);

        // считаем ожидаемую цену бургера
        float expecedPriceSum = mockBun.price * 2 + mockIngredient1.price + mockIngredient2.price + mockIngredient3.price;

        // добавляем моки в бургер
        burger.setBuns(mockBun);
        burger.ingredients.add(mockIngredient1);
        burger.ingredients.add(mockIngredient2);
        burger.ingredients.add(mockIngredient3);

        // проверка
        Assert.assertEquals("Неверная работа метода getPrice", expecedPriceSum, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptReturnsCorrectReceipt() {
        // генерируем поля для моков
        mockBun.name = generateRandomName();
        mockBun.price = generateRandomPrice();

        mockIngredient1.name = generateRandomName();
        mockIngredient1.price = generateRandomPrice();
        mockIngredient1.type = generateRandomIngredientType();

        mockIngredient2.name = generateRandomName();
        mockIngredient2.price = generateRandomPrice();
        mockIngredient2.type = generateRandomIngredientType();

        mockIngredient3.name = generateRandomName();
        mockIngredient3.price = generateRandomPrice();
        mockIngredient3.type = generateRandomIngredientType();

        // задаем методы моков
        Mockito.when(mockBun.getPrice()).thenReturn(mockBun.price);
        Mockito.when(mockBun.getName()).thenReturn(mockBun.name);

        Mockito.when(mockIngredient1.getPrice()).thenReturn(mockIngredient1.price);
        Mockito.when(mockIngredient1.getName()).thenReturn(mockIngredient1.name);
        Mockito.when(mockIngredient1.getType()).thenReturn(mockIngredient1.type);

        Mockito.when(mockIngredient2.getPrice()).thenReturn(mockIngredient2.price);
        Mockito.when(mockIngredient2.getName()).thenReturn(mockIngredient2.name);
        Mockito.when(mockIngredient2.getType()).thenReturn(mockIngredient2.type);

        Mockito.when(mockIngredient3.getPrice()).thenReturn(mockIngredient3.price);
        Mockito.when(mockIngredient3.getName()).thenReturn(mockIngredient3.name);
        Mockito.when(mockIngredient3.getType()).thenReturn(mockIngredient3.type);

        //формируем список ингредиентов из моков
        List<Ingredient> mockIngredients = new ArrayList<>();
        mockIngredients.add(mockIngredient1);
        mockIngredients.add(mockIngredient2);
        mockIngredients.add(mockIngredient3);

        //ожидаемая стоимость бургера
        float expecedPriceSum = mockBun.price * 2 + mockIngredient1.price + mockIngredient2.price + mockIngredient3.price;

        //формируем ожидаемый чек
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", mockBun.name));

        for (Ingredient ingredient : mockIngredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.type.toString().toLowerCase(),
                    ingredient.name));
        }

        receipt.append(String.format("(==== %s ====)%n", mockBun.name));
        receipt.append(String.format("%nPrice: %f%n", expecedPriceSum));
        String expectedReceipt = receipt.toString();

        // добавляем моки в бургер
        burger.setBuns(mockBun);
        burger.ingredients.add(mockIngredient1);
        burger.ingredients.add(mockIngredient2);
        burger.ingredients.add(mockIngredient3);

        //выводим на экран ожидаемый чек
        System.out.println("Expected receipt:");
        System.out.println(expectedReceipt);

        //выводим на экран получившийся чек
        System.out.println("Actual receipt:");
        System.out.println(burger.getReceipt());

        //проверка
        Assert.assertEquals("Неверная работа метода getReceipt", expectedReceipt, burger.getReceipt());

    }


}
