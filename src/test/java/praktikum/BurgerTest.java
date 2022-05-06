package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest implements SetUp {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Override
    @Before
    public void createObject() {
        burger = new Burger();
    }

    @Test
    public void setBunsWithDefaultValueBunSet() {
        burger.setBuns(bun);
        Assert.assertEquals("Incorrect bun", bun, burger.bun);
    }

    @Test
    public void addIngredientAddTwoIngredientListSizeEqualTwo() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals("Incorrect list size", 2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientListIsEmpty() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue("List is not empty", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientIndexChanged() {
        burger.addIngredient(new Ingredient(SAUCE, "First", 1));
        burger.addIngredient(new Ingredient(FILLING, "Second", 2));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Incorrect Type", SAUCE, burger.ingredients.get(1).type);
        Assert.assertEquals("Incorrect name", "First", burger.ingredients.get(1).name);
        Assert.assertEquals("Incorrect price", 1, burger.ingredients.get(1).price, 0);
    }

    @Test
    public void getPriceReturnCorrectValue() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float price = 10;
        float expectedPrice = price * 2 + price;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        Assert.assertEquals("Incorrect price", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(burger.getPrice()).thenReturn(1255f);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Соус Spicy-X");
        String actualReceipt = burger.getReceipt();

        String expectReceipt = String.format("(==== %s ====)%n", "Краторная булка N-200i") + String.format("= %s %s =%n", "filling", "Соус Spicy-X") +
                String.format("(==== %s ====)%n", "Краторная булка N-200i") +
                String.format("%nPrice: %f%n", 1255.0);

        Assert.assertEquals("Incorrect receipt", expectReceipt, actualReceipt);
    }


}
