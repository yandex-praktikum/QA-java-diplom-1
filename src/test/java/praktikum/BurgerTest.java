package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;
    private final IngredientType sauceType = IngredientType.SAUCE;
    private final String sauceName = "Mayonnaise";
    private final float saucePrice = 100F;
    private final String bunName = "Bread";
    private final float bunPrice = 50F;

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
        System.out.println(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(1);
        Assert.assertFalse(burger.ingredients.contains(ingredient1));
        System.out.println(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0,1);
        Assert.assertEquals(1, burger.ingredients.indexOf(ingredient));
        System.out.println(burger.ingredients.indexOf(ingredient));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(145F);
        Mockito.when(ingredient.getPrice()).thenReturn(145F);
        Assert.assertEquals(435F, burger.getPrice(), 0);
        System.out.println(burger.getPrice());
    }

    @Test
    public void getReceiptTest() {
        float totalPrice = (bunPrice * 2) + saucePrice;
        StringBuilder receiptER = new StringBuilder(
                String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                        bunName, sauceType.toString().toLowerCase(), sauceName, bunName, totalPrice));
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(sauceType);
        Mockito.when(ingredient.getName()).thenReturn(sauceName);
        Mockito.when(ingredient.getPrice()).thenReturn(saucePrice);
        System.out.println(receiptER);
        System.out.println(burger.getReceipt());
        Assert.assertEquals(receiptER.toString(), burger.getReceipt());
    }
}