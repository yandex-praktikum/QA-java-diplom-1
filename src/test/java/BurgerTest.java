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

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        List<Ingredient> expected = new ArrayList<>();
        expected.add(ingredient);
        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> expected = new ArrayList<>();
        expected.add(ingredient);
        expected.remove(ingredient);
        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(1,0);
        List<Ingredient> expected = new ArrayList<>();
        expected.add(0, ingredient);
        expected.add(1, ingredient);
        expected.set(0, expected.get(1));
        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void testGetPriceReturnsPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(1337F);
        Mockito.when(bun.getPrice()).thenReturn(988F);
        float expected = bun.getPrice() * 2 + ingredient.getPrice();
        Assert.assertEquals(expected, burger.getPrice(),0);
    }

    @Test
    public void testGetReceiptReturnsReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Мясо бессмертных моллюсков Protostomia");
        Mockito.when(ingredient.getPrice()).thenReturn(1337F);
        Mockito.when(bun.getPrice()).thenReturn(988F);

        String expected = "(==== " + bun.getName() + " ====)\r\n" + "= " + ingredient.getType().toString().toLowerCase()
                + " " +  ingredient.getName() + " =\r\n" + "(==== " + bun.getName() + " ====)\r\n" + "\r\nPrice: "
                + String.format("%.6f", bun.getPrice() * 2 + ingredient.getPrice()) + "\r\n";

        Assert.assertEquals(expected, burger.getReceipt());
    }
}