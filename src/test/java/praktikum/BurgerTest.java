package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final float saucePrice = 10.0f;
    private final float fillingPrice = 20.0f;
    private final float bunPrice = 5.0f;
    private final float burgerPrice = 40.0f;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;

    @Test
    public void testSetBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(sauce);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(sauce, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(sauce);
        Assert.assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientsWithError() {
        Burger burger = new Burger();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> burger.removeIngredient(0));
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        Ingredient sauce = Mockito.mock(Ingredient.class);

        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        Assert.assertEquals(sauce, burger.ingredients.get(0));
        Assert.assertEquals(filling, burger.ingredients.get(1));

        burger.moveIngredient(0, 1);

        Assert.assertEquals(sauce, burger.ingredients.get(1));
        Assert.assertEquals(filling, burger.ingredients.get(0));
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

        Assert.assertEquals(burgerPrice, burger.getPrice(), 0.00001f);
    }

    @Test
    public void testGetReceipt() {
        String bunName = "Bread";
        String sauceName = "Ketchup";
        String fillingName = "Cutlet";

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

        String result = String.format("(==== %s ====)%n", bunName)
                + String.format("= %s %s =%n", IngredientType.SAUCE.name().toLowerCase(), sauceName)
                + String.format("= %s %s =%n", IngredientType.FILLING.name().toLowerCase(), fillingName)
                + String.format("(==== %s ====)%n", bunName)
                + String.format("%nPrice: %f%n", burgerPrice);

        Assert.assertEquals(result, burger.getReceipt());
    }
}