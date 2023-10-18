package burger.tests;

import org.junit.After;
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

import static org.mockito.ArgumentMatchers.anyInt;
import static praktikum.Burger.ingredients;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;



    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(Mockito.any());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        Mockito.verify(burger).addIngredient(Mockito.any());
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(anyInt());

    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(anyInt(),anyInt());
    }

    @Test
    public void getPriceTest() {
       Burger burger2 = new Burger();

        Mockito.when(bun.getPrice()).thenReturn(500F);
        burger2.setBuns(bun);

        Mockito.when(ingredient1.getPrice()).thenReturn(250F);
        burger2.addIngredient(ingredient1);

        Mockito.when(ingredient2.getPrice()).thenReturn(250F);
        burger2.addIngredient(ingredient2);

        float expectedPrice = 1500F;
        Assert.assertEquals(expectedPrice, burger2.getPrice(), 0.5);

    }

    @Test
    public void getReceiptTest() {
        Burger burger1 = new Burger();
        Mockito.when(bun.getName()).thenReturn("white bun");
        burger1.setBuns(bun);
        String bunString = String.format("(==== %s ====)%n", bun.getName());

        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        Mockito.when(ingredient1.getName()).thenReturn("chilli");
        burger1.addIngredient(ingredient1);
        String sauceString = String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName());

        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.valueOf("FILLING"));
        Mockito.when(ingredient2.getName()).thenReturn("beef cottlete");
        burger1.addIngredient(ingredient2);
        String fillingString = String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName());

        Mockito.when(burger1.getPrice()).thenReturn(1500F);
        String priceString = String.format("%nPrice: %f%n", burger1.getPrice());

        String actualReceipt = burger1.getReceipt();

        Assert.assertEquals(bunString + sauceString + fillingString + bunString + priceString, actualReceipt);
        System.out.println(actualReceipt);
    }

    @After
    public void clearIngredientsAfter() {
        for (int i = ingredients.size(); i >= 1; i--) {
            burger.removeIngredient(i - 1);
        }
    }
}