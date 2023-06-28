package burgerTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import static praktikum.Burger.ingredients;


public class BurgerTest {
    private Burger burger;


    private  Bun bun;

    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Database database = new Database();
        burger = new Burger();
        bun = database.availableBuns().get(1);
     ingredient1 = database.availableIngredients().get(3);
     ingredient2 = database.availableIngredients().get(1);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);

    }
    @After
    public void clearIngredientsAfter(){
        for (int i = burger.ingredients.size(); i >= 1; i--) {
            burger.removeIngredient(i - 1);
        }
    }

    @Test

    public void setBunsTest() {
        Bun bun = Mockito.mock(Bun.class);
        Burger burger = Mockito.mock(Burger.class);
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(Mockito.any());
    }

    @Test
    public void addIngredientTest() {
       Assert.assertNotNull( ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0);
        int ingredientSize = ingredients.size();
        Assert.assertEquals (1, ingredientSize );

    }

    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(1,0);
        Assert.assertEquals(ingredient2, ingredients.get(0));

    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(700, burger.getPrice(), 0.5);
    }



    @Test
    public void getReceiptTest() {
        String actualReceipt = burger.getReceipt();
        String bunString = String.format("(==== %s ====)%n", bun.getName());
        String sauceString = String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName());
        String fillingString = String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName());
        String priceString = String.format("%nPrice: %f%n", burger.getPrice());
        Assert.assertEquals(bunString + sauceString + fillingString + bunString + priceString, actualReceipt);
        System.out.println(bunString + sauceString + fillingString + bunString + priceString);

    }

}