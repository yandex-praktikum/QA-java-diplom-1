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

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {



   float bunPrice = 300;
    float saucePrice = 600;
    float fillingPrice = 600;
    float burgerPrice = 1800;


    @Mock
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;



    @Test
    public void testsetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void testaddIngridient() {
       Burger burger = new Burger();
        burger.addIngredient(filling);
       int actual = burger.ingredients.size();
       int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(0,1);
        assertEquals(burger.ingredients.get(0), sauce);
        assertEquals(burger.ingredients.get(1),filling);
    }

    @Test
    public void testGetPrice() {

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(sauce.getPrice()).thenReturn(saucePrice);
        Mockito.when(filling.getPrice()).thenReturn(fillingPrice);


        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        Assert.assertEquals(burgerPrice, burger.getPrice(),1f);
    }

    @Test
    public void testGetReceipt() {
        String bunName = "red bun";
        String sauceName = "hot sauce";
        String fillingName = "cutlet";

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(sauce.getPrice()).thenReturn(saucePrice);
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn(sauceName);
        Mockito.when(filling.getPrice()).thenReturn(fillingPrice);
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn(fillingName);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String burgerReceipt = String.format("(==== %s ====)%n", bunName) +
                String.format("= %s %s =%n", IngredientType.SAUCE.name().toLowerCase(), sauceName) +
                 String.format("= %s %s =%n", IngredientType.FILLING.name().toLowerCase(), fillingName) +
                String.format("(==== %s ====)%n", bunName) +
                 String.format("%nPrice: %f%n", burgerPrice);

        Assert.assertEquals(burgerReceipt, burger.getReceipt());


    }

    }

