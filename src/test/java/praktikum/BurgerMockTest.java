package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;


@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {

    Burger burger;


    public BurgerMockTest(){
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        Assert.assertEquals(bun,burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient= Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.get(0),ingredient);

    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient0= Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient0);
        Ingredient ingredient1= Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient1);

        //check deletion from index zero
        burger.removeIngredient(0);
        Assert.assertEquals(burger.ingredients.get(0),ingredient1);

        //check deletion from index one
        burger.addIngredient(ingredient0);
        burger.removeIngredient(1);
        Assert.assertEquals(burger.ingredients.get(0),ingredient1);
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient0= Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient0);
        Ingredient ingredient1= Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(1,0);
        Assert.assertEquals(burger.ingredients.get(0),ingredient1);
        Assert.assertEquals(burger.ingredients.get(1),ingredient0);

    }

    @Test
    public void getPriceTest() {

        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);

        Ingredient ingredient= Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);

        Ingredient ingredient1= Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient1);

        Random r = new Random();
        Mockito.when(bun.getPrice()).thenReturn(r.nextFloat());
        Mockito.when(ingredient.getPrice()).thenReturn(r.nextFloat());
        Mockito.when(ingredient1.getPrice()).thenReturn(r.nextFloat());

        Assert.assertEquals(bun.getPrice() * 2 + ingredient.getPrice() + ingredient1.getPrice(),burger.getPrice(),0 );
    }


    @Test
    public void getReceiptTest() {

        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        Ingredient ingredient= Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        Ingredient ingredient1= Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient1);

        Mockito.when(bun.getPrice()).thenReturn(5.00F);
        Mockito.when(ingredient.getPrice()).thenReturn(3.00F);
        Mockito.when(ingredient1.getPrice()).thenReturn(4.00F);

        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(ingredient.getName()).thenReturn("ingredient");
        Mockito.when(ingredient1.getName()).thenReturn("ingredient1");

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);

        String   expt =  "(==== bun ====)\r\n";
                 expt +=  "= filling ingredient =\r\n";
                 expt +=  "= sauce ingredient1 =\r\n";
                 expt +=  "(==== bun ====)\r\n";
                 expt +=  "\r\nPrice: 17.000000\r\n";
        Assert.assertEquals(expt,burger.getReceipt());
    }

}
