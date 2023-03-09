package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends UtilForTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsCreateSuccess() {
        Bun bun=new Bun("white bun", 3f);
        burger.setBuns(bun);
        Assert.assertEquals(bun,burger.bun);
    }

    @Test
    public void addIngredientSuccess() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(2,burger.ingredients.size());
        Assert.assertEquals(ingredient1,burger.ingredients.get(0));
        Assert.assertEquals(ingredient2,burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientSuccess() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        Assert.assertEquals(1,burger.ingredients.size());
    }

    @Test
    public void moveIngredientSuccess() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1,0);
        Assert.assertEquals(ingredient2,burger.ingredients.get(0));
    }

    @Test
    public void getPriceSuccessReturn6() {
        burger.ingredients = List.of(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        Assert.assertEquals(6f, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptSuccessTest() {
        String actualReceipt =
                "(==== Булочка ====)\r\n" +
                        "= sauce Сырный =\r\n" +
                        "(==== Булочка ====)\r\n"+
                        "\r\n"+
                        "Price: 9,000000" +
                        "\r\n";
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(bun.getPrice()).thenReturn(2f);
        burger.addIngredient(ingredient1);
        Assert.assertEquals(actualReceipt,burger.getReceipt());
    }
}