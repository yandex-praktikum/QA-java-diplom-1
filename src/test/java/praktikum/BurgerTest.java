package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class BurgerTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void setBuns() {
        Bun bun = Mockito.mock(Bun.class);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    @Test
    public void addIngredient() {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int actual = burger.ingredients.size();
        int excepted = 1;
        Assert.assertEquals("Error addIngredient",excepted,actual);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actual =  burger.ingredients.size();
        int expected = 0;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void moveIngredientCheckNewIndex() {
        Burger burger = new Burger();
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredientOne = Mockito.mock(Ingredient.class);
        Ingredient ingredientTwo = Mockito.mock(Ingredient.class);

        burger.setBuns(bun);
        burger.ingredients.add(ingredientOne);
        burger.ingredients.add(ingredientTwo);

        burger.moveIngredient(1, 0);

        Assert.assertEquals(ingredientTwo,burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientCheckOldIndex() {
        Burger burger = new Burger();
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredientOne = Mockito.mock(Ingredient.class);
        Ingredient ingredientTwo = Mockito.mock(Ingredient.class);

        burger.setBuns(bun);
        burger.ingredients.add(ingredientOne);
        burger.ingredients.add(ingredientTwo);

        burger.moveIngredient(1, 0);

        Assert.assertEquals(ingredientOne,burger.ingredients.get(1));
    }




    @Test
    public void getPrice() {
        Burger burger = new Burger();
        float price = 200.5f;
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(price);

        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getPrice()).thenReturn(price);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actual = burger.getPrice();
        float excepted = price*2 + price;
        Assert.assertEquals("Error getPrice", excepted,actual,0);
    }

    @Test
    public void getReceipt() {
        String NAME_BUN = "Космическая";
        float PRICE = 200.5f;
        String NAME_FILLING = "Меркурианская";

        Burger burger = new Burger();
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn(NAME_BUN);
        Mockito.when(bun.getPrice()).thenReturn(PRICE);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("FILLING"));
        Mockito.when(ingredient.getName()).thenReturn(NAME_FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE);

        String actual = burger.getReceipt();
        String excepted = "(==== Космическая ====)\r\n"+ "= filling Меркурианская =\r\n" +"(==== Космическая ====)\r\n\r\n" + "Price: 601,500000\r\n";

        Assert.assertEquals("Error getReceipt",excepted,actual);
    }
}