import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;

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
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(ingredient.getName()).thenReturn("Мясо бессмертных моллюсков Protostomia");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(1337f);

        StringBuilder expected = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        expected.append(String.format("= filling %s =%n", ingredient.getName()));
        expected.append(String.format("(==== %s ====)%n", bun.getName()));
        expected.append(String.format("%nPrice: %f%n", bun.getPrice() * 2 + ingredient.getPrice()));
        Assert.assertEquals(expected.toString(), burger.getReceipt());

    }

}
