package praktikum.burger.test.suit;

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

@RunWith(MockitoJUnitRunner.class)
public class BurgerGetPriceAndReceiptTest {
    @Mock
    Bun testBun;
    @Mock
    Ingredient testIngredient;

    @Test
    public void getPriceTest() {
        Burger testBurger = new Burger();
        testBurger.setBuns(testBun);
        testBurger.addIngredient(testIngredient);
        Mockito.when(testBun.getPrice()).thenReturn(42F);
        Mockito.when(testIngredient.getPrice()).thenReturn(15F);
        float actualBurgerPrice = testBurger.getPrice();
        Assert.assertEquals(99F, actualBurgerPrice, 99F - actualBurgerPrice);
    }

    @Test
    public void burgerGetReceiptTest() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(testIngredient);
        testBurger.setBuns(testBun);
        Mockito.when(testBun.getName()).thenReturn("MockBun");
        Mockito.when(testBun.getPrice()).thenReturn(100f);
        testBurger.setBuns(testBun);
        Mockito.when(testIngredient.getName()).thenReturn("mockIngredient");
        Mockito.when(testIngredient.getPrice()).thenReturn(10f);
        Mockito.when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        testBurger.addIngredient(testIngredient);
        System.out.println(testBurger.getReceipt());
        String expectedReceipt = String.format(("(==== " +
                        testBun.getName() +
                        " ====)%n= " +
                        testIngredient.getType().toString().toLowerCase() +
                        " " +
                        testIngredient.getName() +
                        " =%n(==== " +
                        testBun.getName() +
                        " ====)%n%nPrice: %f%n"),
                testBurger.getPrice());
        System.out.println(expectedReceipt);
        Assert.assertEquals(expectedReceipt, testBurger.getReceipt());
    }
}