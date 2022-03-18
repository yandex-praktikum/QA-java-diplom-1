import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

@RunWith(MockitoJUnitRunner.class)

public class BurgerMockTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;


    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(1337F);
        Mockito.when(ingredient.getPrice()).thenReturn(1337F);
        float actualBurgerPrice = bun.getPrice() * 2 + ingredient.getPrice();
        Assert.assertEquals("Цена бургера не совпадает с ожидаемым значением", actualBurgerPrice, burger.getPrice(), 0);

    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(bun.getPrice()).thenReturn(1337F);
        Mockito.when(ingredient.getPrice()).thenReturn(1337F);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()))
                .append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()))
                .append(String.format("(==== %s ====)%n", bun.getName())).append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals("Рецепт бургера не совпадает с ожидаемым значением", receipt.toString(), burger.getReceipt());


    }
}

