package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    Burger burger = new Burger();
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Bun bun;

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        Assert.assertEquals(1, burger.ingredients.size());

    }
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        Assert.assertEquals(2, burger.ingredients.size());
    }
    @Test
    public void removeIngredientsTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertFalse(burger.ingredients.isEmpty());
        for (int i = burger.ingredients.size(); i > 0; i--) {
            burger.removeIngredient(i - 1);
        }
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void getPriceAndGetReceiptBunTest() {
        bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        Assert.assertTrue(burger.getReceipt().contains(burger.bun.getName()));
        Assert.assertEquals(200, burger.getPrice(), 0.0f);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void getReceiptAndGetPriceTest() {
        bun = new Bun("black bun", 100);
        ingredient1 = new Ingredient(IngredientType.FILLING, "sausage", 300);
        ingredient2 = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertTrue(burger.getReceipt().contains(burger.bun.getName()));
        for (int i = 0; i < burger.ingredients.size(); i++) {
            String expected = burger.ingredients.get(i).name;
            String actual = burger.getReceipt();
            Assert.assertTrue(actual.contains(expected));
        }
        Assert.assertTrue(burger.getReceipt().contains(burger.bun.getName()));
        Assert.assertEquals(700, burger.getPrice(), 0.0f);
    }

    @Mock
    Burger burgerMock;

    @Test
    public void getPriceMockTest() {
        Mockito.when(burgerMock.getPrice()).thenReturn(200f);
        Assert.assertEquals(200, burgerMock.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptMockTest() {
        Mockito.when(burgerMock.getReceipt()).thenReturn("Burger");
        Assert.assertEquals("Burger", burgerMock.getReceipt());
    }

    @Test
    public void getReceiptMockVerifyOneTimesTest() {
        burgerMock.getReceipt();
        Mockito.verify(burgerMock, Mockito.times(1)).getReceipt();

    }

    @Test
    public void getPriceMockVerifyOneTimeTest() {
        burgerMock.getPrice();
        Mockito.verify(burgerMock, Mockito.times(1)).getPrice();

    }

    @Test
    public void getReceiptMockVerifySameTimesTest() {
        burgerMock.getReceipt();
        burgerMock.getReceipt();
        burgerMock.getReceipt();
        Mockito.verify(burgerMock, Mockito.times(3)).getReceipt();

    }

    @Test
    public void getPriceMockVerifySameTimesTest() {
        burgerMock.getPrice();
        burgerMock.getPrice();
        burgerMock.getPrice();
        Mockito.verify(burgerMock, Mockito.times(3)).getPrice();

    }
    @Test
    public void test() {
        burgerMock.addIngredient(ingredient1);
        Mockito.verify(burgerMock, Mockito.times(1)).addIngredient(ingredient1);
    }
}
