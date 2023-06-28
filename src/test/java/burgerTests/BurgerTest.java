package burgerTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
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
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Burger burger = Mockito.mock(Burger.class);
       burger.addIngredient(ingredient);
       Mockito.verify(burger).addIngredient(Mockito.any());

    }

    @Test
    public void removeIngredientTest() {

        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        int ingredientSize = Burger.ingredients.size();
        Assert.assertEquals (0, ingredientSize );

    }

    @Test
    public void moveIngredientTest() {

    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Булка", 200);
        Ingredient ingredient = new Ingredient (IngredientType.FILLING, "Котлета", 200);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(600, burger.getPrice(), 0.5);

    }


    @Test
    public void getReceiptTest() {
        Bun bun = new Bun("Булка", 200);

    }
}