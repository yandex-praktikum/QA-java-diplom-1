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

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    //setBuns
    @Test
    public void setBunsIsThisBun() {
        Burger burger = new Burger();
        Bun bun = new Bun("Булка на гриле", 1.59f);
        burger.setBuns(bun);
        Bun actualBun = burger.bun;
        Assert.assertNotNull(actualBun);
    }

    //addIngredient
    @Test
    public void verifyThatIngredientWasAdded() {
        //добавляю элемент в ожидаемую коллекцию
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "da", 1.0f));
        //добавляю элемент в коллецию через метод
        Burger actualIngredients = new Burger();
        actualIngredients.addIngredient(new Ingredient(IngredientType.FILLING, "da", 1.0f));
        //проверяю на соответствие
        Assert.assertTrue(expectedIngredients.get(0).getName().equals(actualIngredients.ingredients.get(0).getName()));
        Assert.assertTrue(expectedIngredients.get(0).getType().equals(actualIngredients.ingredients.get(0).getType()));
        Assert.assertTrue(expectedIngredients.get(0).getPrice() == (actualIngredients.ingredients.get(0).getPrice()));
    }

    //removeIngredient
    @Test
    public void verifyThatIngredientWasRemoved() {
        Burger burger = new Burger();
        //добавляю элемент в коллекцию
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "da", 1.0f));
        int sizeBeforeRemove = burger.ingredients.size();
        //удаляю элемент из коллекции
        burger.removeIngredient(burger.ingredients.size() - 1);
        int sizeAfterRemove = burger.ingredients.size();
        //проверяю, что размер коллекции после удаления изменился
        Assert.assertFalse(sizeBeforeRemove == sizeAfterRemove);
    }

    //moveIngredient
    @Test
    public void verifyThatIngredientWasMoved() {
        //добавляю и меняю местами элементы в ожидаемой коллекции
        List<Ingredient> expectedIngredients = new ArrayList<Ingredient>();
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "название expected", 0.0f));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "название_1", 1.0f));
        expectedIngredients.add(1, expectedIngredients.remove(0));
        System.out.println(expectedIngredients);
        //добавляю и меняю местами элементы в коллекции через метод
        Burger actualIngredients = new Burger();
        actualIngredients.addIngredient(new Ingredient(IngredientType.FILLING, "название actual", 0.0f));
        actualIngredients.addIngredient(new Ingredient(IngredientType.FILLING, "название_1", 1.0f));
        actualIngredients.moveIngredient(1, 0);
        //проверяю на соответствие
        Assert.assertTrue(expectedIngredients.get(0).getName().equals(actualIngredients.ingredients.get(0).getName()));
        Assert.assertTrue(expectedIngredients.get(0).getType().equals(actualIngredients.ingredients.get(0).getType()));
        Assert.assertTrue(expectedIngredients.get(0).getPrice() == (actualIngredients.ingredients.get(0).getPrice()));
    }


    //getPrice
    @Test
    public void getPriceReturnsCorrectPrice() {
        Burger burger = new Burger();
        float firstMockPrice = 1.0f;
        float secondMockPrice = 2.0f;
        float actualPrice;
        float expectedPrice = 5.0f;
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(firstMockPrice);
        Mockito.when(ingredient1.getPrice()).thenReturn(firstMockPrice);
        Mockito.when(ingredient2.getPrice()).thenReturn(secondMockPrice);
        actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }


    //getReceipt
    @Test
    public void getReceiptReturnsCorrectReceipt() {
        Burger burger = new Burger();
        float firstMockPrice = 1.0f;
        float secondMockPrice = 2.0f;
        String mockBunName = "Зажаренная булка";
        String firstMockIngredientName = "Острый";
        String secondMockIngredientName = "Сладкий";
        IngredientType sauce = IngredientType.SAUCE;
        String expectedReceiptString = "(==== Зажаренная булка ====)\n" +
                "= sauce Острый =\n" +
                "= sauce Сладкий =\n" +
                "(==== Зажаренная булка ====)\n" +
                "\n" +
                "Price: 5,000000\n";

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(firstMockPrice);
        Mockito.when(ingredient1.getPrice()).thenReturn(firstMockPrice);
        Mockito.when(ingredient2.getPrice()).thenReturn(secondMockPrice);
        Mockito.when(bun.getName()).thenReturn(mockBunName);
        Mockito.when(ingredient1.getName()).thenReturn(firstMockIngredientName);
        Mockito.when(ingredient2.getName()).thenReturn(secondMockIngredientName);
        Mockito.when(ingredient1.getType()).thenReturn(sauce);
        Mockito.when(ingredient2.getType()).thenReturn(sauce);
        String actualReceiptString = burger.getReceipt();
        Assert.assertEquals(expectedReceiptString, actualReceiptString);
    }
}
