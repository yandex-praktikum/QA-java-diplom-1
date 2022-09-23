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

// Some change to trigger pull request
@RunWith(MockitoJUnitRunner.class)
public class BurgerStubTest {
    // Предполагаем, что классы Bun и Ingredient не готовы. Заменяем их методы заглушками.
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void burgerAddIngridientTest(){
        Burger burger = new Burger();

        burger.addIngredient(ingredient);
    }

    @Test
    public void burgerGetPriceTest(){
        Burger burger = new Burger();

        Mockito.when(bun.getPrice()).thenReturn(49F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        float expectedPrice = 398F;
        Assert.assertEquals("Expected Price = " + expectedPrice, expectedPrice, burger.getPrice(), 0.0001);

    }
    @Test
    public void burgerGetReceiptTest(){
        Burger burger = new Burger();

        Mockito.when(bun.getName()).thenReturn("Bulka");
        Mockito.when(ingredient.getName()).thenReturn("beefsteak");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== Bulka ====)\r\n" +
                "= filling beefsteak =\r\n" +
                "(==== Bulka ====)\r\n" +
                "\r\n" +
                "Price: 0,000000\r\n";
        Assert.assertEquals("Expected Receipt '" + expectedReceipt + "'", expectedReceipt, burger.getReceipt());

    }
}
