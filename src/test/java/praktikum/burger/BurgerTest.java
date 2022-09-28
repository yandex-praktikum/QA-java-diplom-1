package praktikum.burger;

import com.github.javafaker.Faker;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private static List<Ingredient> availableIngredients;
    private static List<Bun> availableBuns;
    private static int ingredientsCnt;
    private static int bunsCnt;

    @BeforeClass
    public static void setUpTestData() {
        Database db = new Database();
        availableIngredients = db.availableIngredients();
        ingredientsCnt = availableIngredients.size();
        availableBuns = db.availableBuns();
        bunsCnt = availableBuns.size();
    }

    @Test
    public void addIngredientAddsOneMoreIngredientToTheList() {
        Burger burger = new Burger();
        Random random = new Random();

        List<Ingredient> expectedListOfIngredients = new ArrayList<>();

        int index = random.nextInt(ingredientsCnt - 1);

        expectedListOfIngredients.add(availableIngredients.get(index));
        burger.addIngredient(availableIngredients.get(index));

        assertEquals("Ingredient was not added: ", expectedListOfIngredients, burger.ingredients);
    }

    @Test
    public void removeIngredientRemovesOneIngredientFromTheList() {
        Burger burger = new Burger();
        Random random = new Random();

        List<Ingredient> expectedListOfIngredients = new ArrayList<>(availableIngredients);
        burger.ingredients.addAll(0, availableIngredients);

        int index = random.nextInt(ingredientsCnt - 1);

        expectedListOfIngredients.remove(index);
        burger.removeIngredient(index);

        assertEquals("Ingredient was not removed: ", expectedListOfIngredients, burger.ingredients);
    }

    @Test
    public void moveIngredientMovesIngredientToTheParticularPlaceOfTheList() {
        Burger burger = new Burger();
        Random random = new Random();

        List<Ingredient> expectedListOfIngredients = new ArrayList<>(availableIngredients);
        burger.ingredients.addAll(0, availableIngredients);

        int index = random.nextInt(ingredientsCnt - 1);
        int newIndex = random.nextInt(ingredientsCnt - 1);

        expectedListOfIngredients.add(newIndex, expectedListOfIngredients.remove(index));
        burger.moveIngredient(index, newIndex);

        assertEquals("Ingredient was not moved: ", expectedListOfIngredients, burger.ingredients);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Burger burger = new Burger();
        Random random = new Random();

        int indexFirstIngredient = random.nextInt(ingredientsCnt - 1);
        int indexSecondIngredient = random.nextInt(ingredientsCnt - 1);
        int indexBun = random.nextInt(bunsCnt - 1);

        burger.ingredients.add(availableIngredients.get(indexFirstIngredient));
        burger.ingredients.add(availableIngredients.get(indexSecondIngredient));
        burger.setBuns(availableBuns.get(indexBun));

        float expectedPrice
                = availableBuns.get(indexBun).getPrice() * 2
                + availableIngredients.get(indexFirstIngredient).getPrice()
                + availableIngredients.get(indexSecondIngredient).getPrice();

        assertEquals("Price is not correct: ", expectedPrice, burger.getPrice(), 0.1);
    }

    @Test
    public void getPriceReturnsCorrectValueMock() {
        Burger burger = new Burger();
        Random random = new Random();

        float ingredientPrice = random.nextFloat();
        float bunPrice = random.nextFloat();

        burger.setBuns(bun);
        burger.ingredients.add(ingredient);

        Mockito.doReturn(bunPrice).when(bun).getPrice();
        Mockito.doReturn(ingredientPrice).when(ingredient).getPrice();

        float expectedPrice = ingredientPrice + bunPrice * 2;

        assertEquals("Price is not correct: ", expectedPrice, burger.getPrice(), 0.1);
    }

    @Test
    public void getReceiptReturnsCorrectValue() {
        Burger burger = new Burger();
        Random random = new Random();

        int indexFirstIngredient = random.nextInt(ingredientsCnt - 1);
        int indexSecondIngredient = random.nextInt(ingredientsCnt - 1);
        int indexBun = random.nextInt(bunsCnt - 1);

        burger.ingredients.add(availableIngredients.get(indexFirstIngredient));
        burger.ingredients.add(availableIngredients.get(indexSecondIngredient));
        burger.setBuns(availableBuns.get(indexBun));

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", availableBuns.get(indexBun).getName()));
        expectedReceipt.append(String.format("= %s %s =%n", availableIngredients.get(indexFirstIngredient).getType().toString().toLowerCase(),
                availableIngredients.get(indexFirstIngredient).getName()));
        expectedReceipt.append(String.format("= %s %s =%n", availableIngredients.get(indexSecondIngredient).getType().toString().toLowerCase(),
                availableIngredients.get(indexSecondIngredient).getName()));
        expectedReceipt.append(String.format("(==== %s ====)%n", availableBuns.get(indexBun).getName()));

        float expectedPrice
                = availableBuns.get(indexBun).getPrice() * 2
                + availableIngredients.get(indexFirstIngredient).getPrice()
                + availableIngredients.get(indexSecondIngredient).getPrice();

        expectedReceipt.append(String.format("%nPrice: %f%n", expectedPrice));

        assertEquals("Receipt is not correct: ", expectedReceipt.toString(), burger.getReceipt());
    }

    @Test
    public void getReceiptReturnsCorrectValueMock() {
        Burger burger = new Burger();
        Random random = new Random();
        Faker faker = new Faker();

        float ingredientPrice = random.nextFloat();
        float bunPrice = random.nextFloat();
        String ingredientName = faker.regexify("[A-Za-z]{6}");
        String bunName = faker.regexify("[A-Za-z]{6}");
        IngredientType ingredientType = IngredientType.FILLING;

        burger.setBuns(bun);
        burger.ingredients.add(ingredient);

        Mockito.doReturn(bunPrice).when(bun).getPrice();
        Mockito.doReturn(ingredientPrice).when(ingredient).getPrice();
        Mockito.doReturn(bunName).when(bun).getName();
        Mockito.doReturn(ingredientName).when(ingredient).getName();
        Mockito.doReturn(ingredientType).when(ingredient).getType();

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(),
                ingredientName));
        expectedReceipt.append(String.format("(==== %s ====)%n", bunName));

        float expectedPrice = ingredientPrice + bunPrice * 2;

        expectedReceipt.append(String.format("%nPrice: %f%n", expectedPrice));

        assertEquals("Receipt is not correct: ", expectedReceipt.toString(), burger.getReceipt());
    }
}
