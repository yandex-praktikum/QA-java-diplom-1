package praktikum;

import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final static String BUN_NAME = "MegaBun";
    private static final float BUN_PRICE = 0.1f;
    private final static String INGREDIENT_NAME = "SuperIngredient";
    private static final float INGREDIENT_PRICE = 0.5f;
    @Mock
    Bun bun;
    Burger burger = new Burger();
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;

    @Test
    public void setBunsSetBurgerPriceAs2BunPrice() {
        burger.setBuns(bun);
        float expectedPrice = BUN_PRICE*2;

        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);

        float actualPrice = burger.getPrice();
        Mockito.verify(bun, Mockito.times(1)).getPrice();

        Assert.assertEquals(expectedPrice, actualPrice, 0.001f);
    }

    @Test
    public void addIngredientSetBurgerPriceAs2BunPriceAndIngredientPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(0.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);

        float actualPrice = burger.getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();

        Assert.assertEquals(INGREDIENT_PRICE, actualPrice, 0.001f);
    }

    @Test
    public void removeIngredientSetBurgerPriceAs2BunPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);

        float expectedPrice = BUN_PRICE*2;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.001f);

        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient, Mockito.times(0)).getPrice();
    }

    @Test
    public void moveIngredientSetBurgerPriceToPriceOfMovedIngredientAfterRemovingOtherOne() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        burger.getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient1, Mockito.times(1)).getPrice();

        burger.moveIngredient(0, 1);
        burger.removeIngredient(1);
        burger.getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient1, Mockito.times(2)).getPrice();
    }

    @Test
    public void getPriceIsEqualsTo2BunPriceAndIngredientPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = 2*BUN_PRICE + INGREDIENT_PRICE ;

        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);

        float actualPrice = burger.getPrice();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();

        Assert.assertEquals(expectedPrice, actualPrice, 0.001f);
    }

    @Test
    public void getReceiptOutputCorrespondingTheExpectedOutput() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);

        float expectedPrice = 2*BUN_PRICE + INGREDIENT_PRICE;

        String expectedReceipt = String.format("(==== %s ====)%n", BUN_NAME)
                + String.format("= %s %s =%n", IngredientType.FILLING.name().toLowerCase(), INGREDIENT_NAME)
                + String.format("(==== %s ====)%n", BUN_NAME)
                + String.format("%nPrice: %f%n", expectedPrice);
        String actualReceipt = burger.getReceipt();
        assertThat(expectedReceipt, is(actualReceipt));
    }
}