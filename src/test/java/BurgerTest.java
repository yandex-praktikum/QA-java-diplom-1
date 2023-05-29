import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    Burger burger = new Burger();

    @Test
    public void checkAddIngredientReturnsSize(){
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredientRemovesGivenIndex(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void checkGetPriceReturnsCorrectPrice(){
        burger.setBuns(bun);
        float bunPrice = 988;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        burger.addIngredient(ingredient);
        float ingredientPrice = 1337;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Assert.assertEquals(bunPrice * 2 + ingredientPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceiptReturnsCorrectReceipt(){
        burger.setBuns(bun);
        ingredient.getName();
        burger.getPrice();

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (var ingredient : burger.ingredients) {
            expectedReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }

}
