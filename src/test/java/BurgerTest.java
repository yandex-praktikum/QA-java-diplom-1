import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {
    Burger burger;

    final String bunName = "fluorescent bun";
    final float bunPrice = 988;
    final String burgerSauce = "spicy";
    final int saucePrice = 90;
    final String burgerFilling = "meat";
    final int fillingPrice = 3000;


    public Bun getMockedBun(String name, float price) {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn(name);
        when(bun.getPrice()).thenReturn(price);
        return bun;
    }

    public Ingredient getMockedIngredient(IngredientType type, String name, float price) {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(type);
        when(ingredient.getName()).thenReturn(name);
        when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        Bun expected = getMockedBun (bunName, bunPrice);
        burger.setBuns(expected);
        Assert.assertEquals(expected, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient expected = getMockedIngredient(IngredientType.FILLING, burgerFilling, fillingPrice);
        burger.addIngredient(expected);
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("Expected " + burgerFilling + "for " + fillingPrice, expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, burgerFilling, fillingPrice);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient firstIngredient = getMockedIngredient(IngredientType.FILLING, burgerFilling, fillingPrice);
        Ingredient secondIngredient = getMockedIngredient(IngredientType.SAUCE, burgerSauce, saucePrice);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient.name, burger.ingredients.get(1).name);
    }
}