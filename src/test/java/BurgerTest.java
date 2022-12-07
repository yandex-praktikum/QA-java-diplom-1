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

import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;
    Burger burger;

    @Before
    public void init(){
        burger = new Burger();
    }

    @Test
    public void  burgerGetPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Assert.assertEquals(300f, burger.getPrice(), 0.000001);
    }

    @Test
    public void addIngredientTest() {
        int countIngredients = burger.ingredients.size();
        burger.addIngredient(new Ingredient(SAUCE, "salmon", 150.5f));
        Assert.assertEquals(countIngredients + 1, burger.ingredients.size());
    }

    @Test
    public void  removeIngredientTest() {
        burger.addIngredient(new Ingredient(SAUCE, "salmon", 150.5f));
        int countIngredients = burger.ingredients.size();
        Assert.assertEquals(countIngredients, burger.ingredients.size());

        int lastIndex = burger.ingredients.size() - 1;
        burger.removeIngredient(lastIndex);
        Assert.assertEquals(countIngredients - 1, burger.ingredients.size());
    }

   @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Mockito.when(bun.getName()).thenReturn("delicious bun");
        Mockito.when(ingredient.getName ()).thenReturn("sour cream");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        StringBuilder receiptExpected = new StringBuilder(String.format("(==== %s ====)%n", "delicious bun"));
        receiptExpected.append(String.format("= %s %s =%n", "sauce", "sour cream"));
        receiptExpected.append(String.format("(==== %s ====)%n", "delicious bun"));
        receiptExpected.append(String.format("%nPrice: %f%n", 300f));
        Assert.assertEquals(receiptExpected.toString(), burger.getReceipt());
    }
}


