package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Burger burgerMock;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;

    @Test
    public void setBunInMockBurger1TimesReturn1() {
        burgerMock.setBuns(bun);

        Mockito.verify(burgerMock).setBuns(bun);
        Mockito.verify(burgerMock, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void setBunMockBunExpectedBun() {
        Burger burger = new Burger();

        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientInMockBurger2TimesReturn2() {

        burgerMock.addIngredient(ingredient1);
        burgerMock.addIngredient(ingredient2);

        Mockito.verify(burgerMock, Mockito.times(2)).addIngredient(Mockito.any());
    }

    @Test
    public void addIngredientInMockBurgerDonTAddReturn0() {

        Mockito.verify(burgerMock, Mockito.times(0)).addIngredient(Mockito.any());
    }

    @Test
    public void addIngredientInMockBurgerNTimesReturnN() {

        int n = 5;
        for (int i = 0; i < n; i++) {
            burgerMock.addIngredient(ingredient1);
        }
        Mockito.verify(burgerMock, Mockito.times(n)).addIngredient(Mockito.any());
    }

    @Test
    public void addIngredientNTimesReturnSizeN() {
        Burger burger = new Burger();

        int nAddTimes = 5;
        for (int i = 0; i < nAddTimes; i++) {
            burger.addIngredient(ingredient1);
        }

        Assert.assertNotNull(burger);
        Assert.assertEquals("Фактический размер списка отличается от ожидаемого", nAddTimes, burger.ingredients.size());
    }

    @Test
    public void removeIngredientReturnNegative1() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(burger.ingredients.indexOf(ingredient1));
        int actual = burger.ingredients.indexOf(ingredient1);

        Assert.assertEquals("Ингредиент не удален", -1, actual);
    }

    @Test
    public void removeIngredientSizeListDecreasedBy1() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);

        burger.removeIngredient(0);
        int sizeActual = burger.ingredients.size();

        Assert.assertNotNull(burger);
        Assert.assertEquals("Фактический размер списка отличается от ожидаемого", 0, sizeActual);
    }

    @Test
    public void removeIngredientWithSameIngredientSizeListDecreasedBy1() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient1);

        burger.removeIngredient(0);
        int sizeActual = burger.ingredients.size();
        int indexActual = burger.ingredients.indexOf(ingredient1);

        Assert.assertEquals("Фактический размер списка отличается от ожидаемого", 1, sizeActual);
        Assert.assertNotEquals("Все одинаковые ингредиенты удалены", -1, indexActual);
    }

    @Test
    public void removeIngredientNTimesSizeListDecreasedByN() {
        int nAddTimes = 5;
        int nRemoveTimes = 4;
        Burger burger = new Burger();
        for (int i = 0; i < nAddTimes; i++) {
            burger.addIngredient(ingredient1);
        }
        int sizeBefore = burger.ingredients.size();
        int sizeExpected = sizeBefore - nRemoveTimes;

        for (int i = 0; i < nRemoveTimes; i++) {
            burger.removeIngredient(0);
        }
        int sizeActual = burger.ingredients.size();

        Assert.assertEquals("Фактический размер списка отличается от ожидаемого", sizeExpected, sizeActual);
    }

    @Test
    public void removeIngredientInBurgerWithoutIngredientExpectedException() {
        Burger burger = new Burger();
        Assert.assertThrows("Ожидаемая ошибка отсутствует.", Exception.class, () -> burger.removeIngredient(0));
    }

    @Test
    public void moveIngredientMoveIngredient1toIngredient3() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        int sizeExpected = burger.ingredients.size();

        int indexExpected = burger.ingredients.indexOf(ingredient3);

        burger.moveIngredient(burger.ingredients.indexOf(ingredient1), burger.ingredients.indexOf(ingredient3));
        int indexActual = burger.ingredients.indexOf(ingredient1);
        int sizeActual = burger.ingredients.size();

        Assert.assertEquals("Фактический индекс отличается от ожидаемого.", indexExpected, indexActual);
        Assert.assertEquals("Изменился размер списка ингредиентов.", sizeExpected, sizeActual);
    }

    @Test
    public void moveIngredientMoveIngredient3toIngredient2() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        int sizeExpected = burger.ingredients.size();
        int indexExpected = burger.ingredients.indexOf(ingredient2);

        burger.moveIngredient(burger.ingredients.indexOf(ingredient3), burger.ingredients.indexOf(ingredient2));
        int indexActual = burger.ingredients.indexOf(ingredient3);
        int sizeActual = burger.ingredients.size();

        Assert.assertEquals("Фактический индекс отличается от ожидаемого.", indexExpected, indexActual);
        Assert.assertEquals("Изменился размер списка ингредиентов.", sizeExpected, sizeActual);
    }

    @Test
    public void moveIngredientInBurgerWithoutIngredientExpectedException() {
        Burger burger = new Burger();
        Assert.assertThrows("Ожидаемая ошибка отсутствует.", Exception.class, () -> burger.moveIngredient(0, 1));
    }

    @Test
    public void getPriceWithBunAndIngredientReturnPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getPrice()).thenReturn(150f);
        Mockito.when(ingredient1.getPrice()).thenReturn(200f);
        Mockito.when(ingredient2.getPrice()).thenReturn(200f);

        float expected = 700;

        float actual = burger.getPrice();

        Assert.assertEquals("Фактическая цена отличается от ожидаемой.", expected, actual, 0.00f);
    }

    @Test
    public void getPriceWithBunAndWithoutIngredientsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        Mockito.when(bun.getPrice()).thenReturn(150f);

        float expected = 300;

        float actual = burger.getPrice();

        Assert.assertEquals("Фактическая цена отличается от ожидаемой.", expected, actual, 0.00f);
    }

    @Test
    public void getPriceWithBunAndSameIngredients() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient1);

        Mockito.when(bun.getPrice()).thenReturn(150f);
        Mockito.when(ingredient1.getPrice()).thenReturn(200f);

        float expected = 700;

        float actual = burger.getPrice();

        Assert.assertEquals("Фактическая цена отличается от ожидаемой.", expected, actual, 0.00f);
    }

    @Test
    public void getPriceWithoutBunExpectedException() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Assert.assertThrows("Ожидаемая ошибка отсутствует.", Exception.class, () -> burger.getPrice());
    }

    @Test
    public void getReceiptTestWithBunAndIngredientsReturnReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        Mockito.when(bun.getName()).thenReturn("Ржаная булочка");
        Mockito.when(bun.getPrice()).thenReturn(150f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Сырный соус");
        Mockito.when(ingredient1.getPrice()).thenReturn(200f);

        String receiptExpected = String.format("(==== Ржаная булочка ====)%n= sauce Сырный соус =%n(==== Ржаная булочка ====)%n%nPrice: 500,000000%n");
        String receipt = burger.getReceipt();

        Assert.assertEquals("Фактический рецепт отличается от ожидаемого", receiptExpected, receipt);
    }

    @Test
    public void getReceiptWithBunAnd2SameIngredientsReturnReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient1);

        Mockito.when(bun.getName()).thenReturn("Ржаная булочка");
        Mockito.when(bun.getPrice()).thenReturn(150f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("Котлета");
        Mockito.when(ingredient1.getPrice()).thenReturn(200f);

        String receiptExpected = String.format("(==== Ржаная булочка ====)%n= filling Котлета =%n= filling Котлета =%n(==== Ржаная булочка ====)%n%nPrice: 700,000000%n");
        String receipt = burger.getReceipt();


        Assert.assertEquals("Фактический рецепт отличается от ожидаемого", receiptExpected, receipt);
    }

    @Test
    public void getReceiptWithBunAnd3DifferentIngredientsReturnReceipt() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        Mockito.when(bun.getName()).thenReturn("Ржаная булочка");
        Mockito.when(bun.getPrice()).thenReturn(150f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Барбекю");
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("Котлета");
        Mockito.when(ingredient2.getPrice()).thenReturn(200f);
        Mockito.when(ingredient3.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient3.getName()).thenReturn("Сыр");
        Mockito.when(ingredient3.getPrice()).thenReturn(100f);

        String receiptExpected = String.format("(==== Ржаная булочка ====)%n= sauce Барбекю =%n= filling Котлета =%n= filling Сыр =%n(==== Ржаная булочка ====)%n%nPrice: 650,000000%n");
        String receipt = burger.getReceipt();

        Assert.assertEquals("Фактический рецепт отличается от ожидаемого", receiptExpected, receipt);
    }

    @Test
    public void getReceiptWithoutIngredientsReturnReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn("Ржаная булочка");
        Mockito.when(bun.getPrice()).thenReturn(150f);

        String receiptExpected = String.format("(==== Ржаная булочка ====)%n(==== Ржаная булочка ====)%n%nPrice: 300,000000%n");

        String receipt = burger.getReceipt();

        Assert.assertEquals("Фактический рецепт отличается от ожидаемого", receiptExpected, receipt);
    }

    @Test
    public void getReceiptWithoutBunExpectedException() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Assert.assertThrows("Ожидаемая ошибка отсутствует.", Exception.class, () -> burger.getReceipt());
    }
}
