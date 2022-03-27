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

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void getBurgerPriceTest() {

        float bunPrice = 100;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        float ingredientPrice = 200;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actualPrice = burger.getPrice();
        float expectedPrice = (bunPrice * 2 + ingredientPrice);

        Assert.assertEquals(expectedPrice, actualPrice, 0.00001);
    }

    @Test
    public void getBurgerReceiptTest() {
        String bunName = "red bun";
        Mockito.when(bun.getName()).thenReturn(bunName);

        IngredientType typeOfIngredient = IngredientType.SAUCE;
        Mockito.when(ingredient.getType()).thenReturn(typeOfIngredient);

        String ingredientName = "chili sauce";
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);

        float bunPrice = 300;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        float ingredientPrice = 300;
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.getPrice();

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = (String.format("(==== red bun ====)%n" + "= sauce chili sauce =%n" + "(==== red bun ====)%n" + "%nPrice: 900,000000%n"));

        Assert.assertEquals(expectedReceipt, actualReceipt);
    }

}

