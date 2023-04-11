package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

   @Mock
   Ingredient ingredient;

   @Mock
   Bun bun;

   Burger burger = new Burger();

   //expected data
   final private String bunName = "tasty bun";
   final private Float bunPrice = 100.0f;
   final private String ingredientName = "delicious ingredient";
   final private Float ingredientPrice = 20.0f;

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Float expectedPrice = bunPrice*2 + ingredientPrice;

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.05);
    }


    @Test
    public void testGetReceipt(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        StringBuilder expected = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        expected.append(String.format("= filling %s =%n", ingredientName));
        expected.append(String.format("(==== %s ====)%n", bunName));
        expected.append(String.format("%nPrice: %f%n", bunPrice*2 + ingredientPrice ));

        Assert.assertEquals(expected.toString(), burger.getReceipt());

    }
}
