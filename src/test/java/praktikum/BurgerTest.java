package praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;

import static praktikum.Generator.*;

@RunWith(JUnitParamsRunner.class)
public class BurgerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Bun bunMock;

    @Mock
    Ingredient ingredientMock, ingredientMock1;

    private Burger burgerTest;

    @Before
    public void setUp(){
        burgerTest = new Burger();
    }

    @Test
    public void setBunsWorksCorrectly() {
        burgerTest.setBuns(bunMock);
        Assert.assertEquals(bunMock, burgerTest.bun);
    }

    @Test
    public void addIngredientWorksCorrectly() {
        burgerTest.addIngredient(ingredientMock);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(ingredientMock)),
                burgerTest.ingredients);
    }

    @Test
    public void removeIngredientWorksCorrectly() {
        burgerTest.addIngredient(ingredientMock);
        burgerTest.removeIngredient(0);
        Assert.assertTrue(burgerTest.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientWorksCorrectly() {
        burgerTest.addIngredient(ingredientMock);
        burgerTest.addIngredient(ingredientMock1);
        burgerTest.moveIngredient(0, 1);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(ingredientMock1, ingredientMock)),
                burgerTest.ingredients);
    }

    @Test
    public void getPriceReturnsValidValue() {
        burgerTest.setBuns(bunMock);
        Mockito.when(bunMock.getPrice()).thenReturn(10.0F);
        burgerTest.addIngredient(ingredientMock);
        Mockito.when(ingredientMock.getPrice()).thenReturn(15.0F);
        Assert.assertEquals(35.0F, burgerTest.getPrice(), 0.0);
    }

    @Test
    @Parameters(method = "getReceiptParameters")
    public void getReceiptReturnsValidValue(boolean haveIngredient, String receipt) {
        burgerTest.setBuns(bunMock);
        Mockito.when(bunMock.getName()).thenReturn(BUN_TEST_NAME);
        Mockito.when(bunMock.getPrice()).thenReturn(10.0F);
        if (haveIngredient) {
            burgerTest.addIngredient(ingredientMock);
            Mockito.when(ingredientMock.getName()).thenReturn(INGREDIENT_TEST_NAME);
            Mockito.when(ingredientMock.getType()).thenReturn(INGREDIENT_TEST_TYPE);
            Mockito.when(ingredientMock.getPrice()).thenReturn(15.0F);
        }
        Assert.assertEquals(receipt, burgerTest.getReceipt());
    }
    private Object[][] getReceiptParameters() {
        return new Object[][]{
                {false, "(==== Test bun ====)\r\n" +
                        "(==== Test bun ====)\r\n" +
                        "\r\nPrice: 20,000000\r\n"},
                {true, "(==== Test bun ====)\r\n" +
                        "= sauce Test ingredient =\r\n" +
                        "(==== Test bun ====)\r\n" +
                        "\r\nPrice: 35,000000\r\n"},
        };
    }
}