package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    Burger burger = new Burger();
    String bunName = "tasty bun";
    float bunPrice = 109;
    String sauceName = "perfect sauce";
    float saucePrice = 99;
    String fillingName = "bacon";
    float fillingPrice = 199;



    @Mock
    Database database;

    List<Bun> buns = Arrays.asList(new Bun (bunName, bunPrice));
    List<Ingredient> ingredients = Arrays.asList(
            new Ingredient(IngredientType.SAUCE, sauceName, saucePrice ),
            new Ingredient(IngredientType.FILLING, fillingName, fillingPrice)
    );

    @Before
    public void setUp() {
        Mockito.when(database.availableBuns()).thenReturn(buns);
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(database.availableBuns().get(0));
        assertEquals("A bun with wrong name in the burger", bunName, burger.bun.getName());
        assertEquals("A bun with wrong price in the burger", bunPrice,burger.bun.getPrice(),0);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(database.availableIngredients().get(0));
        assertEquals("Wrong number of ingredients in the burger", 1, burger.ingredients.size());
        assertEquals("An ingredient with wrong price in the burger", saucePrice, burger.ingredients.get(0).price,0);
        assertEquals("An ingredient with wrong name in the burger", sauceName, burger.ingredients.get(0).name);
        assertEquals("An ingredient of wrong type in the burger", IngredientType.SAUCE, burger.ingredients.get(0).type);
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(database.availableIngredients().get(0));
        burger.removeIngredient(0);
        assertEquals("The ingredient was not removed", 0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.moveIngredient(1,0);
        assertEquals("Wrong number of ingredients in the burger", 2, burger.ingredients.size());
        assertEquals("An ingredient with wrong price is the first in the burger", fillingPrice, burger.ingredients.get(0).price,0);
        assertEquals("An ingredient with wrong name is the first in the burger", fillingName, burger.ingredients.get(0).name);
        assertEquals("An ingredient of wrong type is the first in the burger", IngredientType.FILLING, burger.ingredients.get(0).type);
    }


    @Test
    public void testGetPrice() {
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        float expectedPrice = bunPrice*2 + saucePrice + fillingPrice;
        assertEquals(expectedPrice, burger.getPrice(),0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        String expected = String.format("(==== %s ====)%n", bunName) +
                String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(), sauceName) +
                String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), fillingName) +
                String.format("(==== %s ====)%n", bunName) +
                String.format("%nPrice: %f%n", (burger.getPrice()));
        assertEquals("Wrong receipt", expected, burger.getReceipt());
    }
}