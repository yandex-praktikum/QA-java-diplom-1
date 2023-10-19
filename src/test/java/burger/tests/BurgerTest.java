package burger.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.mockito.ArgumentMatchers.any;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


public class BurgerTest {

    @Mock
    Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
        bun = new Bun("White bun", 500F);
        burger.setBuns(bun);
        ingredient1 = new Ingredient(SAUCE, "chily", 250F);
        ingredient2 = new Ingredient(FILLING, "beefCutlete", 250F);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

    }

    @Test
    public void setBunsTest() {
        //burger.setBuns(bun);
        Mockito.verify(burger).setBuns(any());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        Mockito.verify(burger, Mockito.times(3)).addIngredient(any());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger4 = new Burger();
        burger4.addIngredient(ingredient1);
        burger4.addIngredient(ingredient2);
        burger4.removeIngredient(0);
        int expectedIngredientsSize = 1;
        Assert.assertEquals(expectedIngredientsSize,burger4.ingredients.size());

    }

    @Test
    public void moveIngredientTest() {
        Burger burger3 = new Burger();
        burger3.addIngredient(ingredient1);
        burger3.addIngredient(ingredient2);
        burger3.moveIngredient(1, 0);
        Ingredient movedIngredient = burger3.ingredients.get(0);
        Assert.assertEquals("beefCutlete", movedIngredient.getName());
    }

    @Test
    public void getPriceTest() {
        Burger burger1 = new Burger();
        burger1.setBuns(bun);
        burger1.addIngredient(ingredient1);
        burger1.addIngredient(ingredient2);
        float actualPrice = burger1.getPrice();
        System.out.println(actualPrice);
        float expectedPrice = 1500F;
        Assert.assertEquals(expectedPrice, actualPrice, 0.5);
    }

    @Test
    public void getReceiptTest() {
        Burger burger2 = new Burger();

        burger2.setBuns(bun);
        String bunString = String.format("(==== %s ====)%n", bun.getName());

        burger2.addIngredient(ingredient1);
        burger2.addIngredient(ingredient2);
        String sauceString = String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName());
        String fillingString = String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName());

        String priceString = String.format("%nPrice: %f%n", burger2.getPrice());

        String actualReceipt = burger2.getReceipt();

        Assert.assertEquals(bunString + sauceString + fillingString + bunString + priceString, actualReceipt);
        System.out.println(actualReceipt);
        System.out.println(bunString + sauceString + fillingString + bunString + priceString);
    }
}