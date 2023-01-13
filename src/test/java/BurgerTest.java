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


    final String SAUCE = "hot sauce";
    final int SAUCE_PRICE = 100;
    final String FILLING = "dinosaur";
    final int FILLING_PRICE = 200;
    final String BUN = "red bun";
    final int BUN_PRICE = 300;

    public Ingredient getMockedIngredient(IngredientType type, String name, float price) {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(type);
        when(ingredient.getName()).thenReturn(name);
        when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }

    public Bun getMockedBun(String name, float price) {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn(name);
        when(bun.getPrice()).thenReturn(price);
        return bun;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        Bun expected = getMockedBun (BUN, BUN_PRICE);
        burger.setBuns(expected);
        Assert.assertEquals(expected, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient expected = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
        burger.addIngredient(expected);
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("Expected " + FILLING + "for " + FILLING_PRICE, expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient firstIngredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
        Ingredient secondIngredient = getMockedIngredient(IngredientType.SAUCE, SAUCE, SAUCE_PRICE);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient.name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceTest() {
        Bun bun = getMockedBun(BUN, BUN_PRICE);
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        Assert.assertEquals(800, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = getMockedBun(BUN, BUN_PRICE);
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = String.format("(==== red bun ====)%n" +
                "= filling dinosaur =%n" +
                "(==== red bun ====)%n" +
                "%n" +
                "Price: 800,000000%n");
        Assert.assertEquals("Receipt - " + expected, expected, actual);
    }
}