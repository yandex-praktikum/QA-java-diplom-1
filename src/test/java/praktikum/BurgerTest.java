package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Test
    public void setBunsReturnsCorrectValue (){

        Burger burger = new Burger();
        Bun bun = new Bun("булочка с кунжутом", 0.05f);
        String expectedName = "булочка с кунжутом";

        burger.setBuns(bun);
        Assert.assertEquals(expectedName, bun.getName());
    }

    @Test
    public void addIngredientsAddsToList (){

        Burger burger = new Burger();
        Ingredient expectedIngredient_01 = new Ingredient(IngredientType.SAUCE, "bbq", 0.01f);
        Ingredient expectedIngredient_02 = new Ingredient(IngredientType.FILLING, "начинкО", 0.02f);

        burger.addIngredient(expectedIngredient_01);
        Assert.assertEquals(expectedIngredient_01, burger.ingredients.get(0));

        burger.addIngredient(expectedIngredient_02);
        Assert.assertEquals(expectedIngredient_02, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientRemovesFromList (){

        Burger burger = new Burger();
        Ingredient ingredient_01 = new Ingredient(IngredientType.SAUCE, "bbq", 0.01f);
        Ingredient ingredient_02 = new Ingredient(IngredientType.FILLING, "начинкО", 0.02f);

        burger.addIngredient(ingredient_01);
        burger.addIngredient(ingredient_02);

        Assert.assertEquals(ingredient_01, burger.ingredients.get(0));
        Assert.assertEquals(ingredient_02, burger.ingredients.get(1));

        burger.removeIngredient(0);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredient_02, burger.ingredients.get(0));

        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientMovesCorrectly (){

        Burger burger = new Burger();
        Ingredient ingredient_01 = new Ingredient(IngredientType.SAUCE, "bbq", 0.01f);
        Ingredient ingredient_02 = new Ingredient(IngredientType.FILLING, "начинкО", 0.02f);

        burger.addIngredient(ingredient_01);
        burger.addIngredient(ingredient_02);

        Assert.assertEquals(ingredient_01, burger.ingredients.get(0));
        Assert.assertEquals(ingredient_02, burger.ingredients.get(1));

        burger.moveIngredient(0, 1);

        Assert.assertEquals(ingredient_02, burger.ingredients.get(0));
        Assert.assertEquals(ingredient_01, burger.ingredients.get(1));

    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient_01;

    @Mock
    Ingredient ingredient_02;

    @Test
    public void getPriceReturnsCorrectValue (){

        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients.add(ingredient_01);
        burger.ingredients.add(ingredient_02);

        Mockito.when(bun.getPrice()).thenReturn(0.05f);
        Mockito.when(ingredient_01.getPrice()).thenReturn(0.01f);
        Mockito.when(ingredient_02.getPrice()).thenReturn(0.02f);

        float expectedPrice = 0.13f;
        float actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void getReceiptReturnsExpectedtValue (){

        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients.add(ingredient_01);
        burger.ingredients.add(ingredient_02);

        Mockito.when(bun.getName()).thenReturn("булочка с кунжутом");
        Mockito.when(bun.getPrice()).thenReturn(0.05f);
        Mockito.when(ingredient_01.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient_01.getName()).thenReturn("barbeque");
        Mockito.when(ingredient_02.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient_02.getName()).thenReturn("начинкО");
        Mockito.when(ingredient_01.getPrice()).thenReturn(0.01f);
        Mockito.when(ingredient_02.getPrice()).thenReturn(0.02f);

        String expectedReceipt = "(==== булочка с кунжутом ====)\r\n" +
                "= sauce barbeque =\r\n" +
                "= filling начинкО =\r\n" +
                "(==== булочка с кунжутом ====)\r\n" +
                "\r\n" +
                "Price: 0.130000\r\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }

}
