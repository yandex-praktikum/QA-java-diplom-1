import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    Burger burger = new Burger();
    float bunPrice = 100;
    float ingredientPrice = 100;
    float ingredient1Price = 150;
    float burgerPrice = bunPrice * 2 + ingredientPrice;
    float burger1Price = bunPrice * 2 + ingredientPrice + ingredient1Price;
    IngredientType ingredientType = IngredientType.SAUCE;
    String bunName = "simple bun";
    String ingredientName = "simple ingredient";
    String ingredient1Name = "simple ingredient1";
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;

    private String createExpectedReceipt() {

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(), ingredientName));
        expectedReceipt.append(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("%nPrice: %f%n", burgerPrice));

        return expectedReceipt.toString();
    }

    private String createExpectedReceipt1() {

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(), ingredient1Name));
        expectedReceipt.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(), ingredientName));

        expectedReceipt.append(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger1Price));

        return expectedReceipt.toString();
    }

    @Test
    public void checkBurgerGetPrice() {

        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Assert.assertEquals(burgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkBurgerGetReceipt() {
        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Assert.assertEquals(createExpectedReceipt(), burger.getReceipt());
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        burger.removeIngredient(0);

        Assert.assertEquals(createExpectedReceipt(), burger.getReceipt());
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient1.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient1.getName()).thenReturn(ingredient1Name);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient1.getPrice()).thenReturn(ingredient1Price);

        burger.moveIngredient(0,1);

        Assert.assertEquals(createExpectedReceipt1(), burger.getReceipt());
    }
}
