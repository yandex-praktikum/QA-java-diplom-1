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
public class BurgerTest {
    Burger burger = new Burger();

    String EXPECTED_RECEIPT = "(==== Краторная булка N-200i ====)\r\n" +
            "= sauce Соус фирменный Space Sauce =\r\n" +
            "(==== Краторная булка N-200i ====)\r\n" +
            "\r\n" +
            "Price: 300,000000\r\n";
    @Mock
    Ingredient ingredient;

    @Test
    public void addIngredientCheck() {

        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
        System.out.println("Размер массива = " + burger.ingredients.size());
    }

    @Test
    public void removeIngredientCheck() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientCheck() {
        burger.addIngredient(new Ingredient(null, "Соус Spicy-X", 90));
        burger.addIngredient(new Ingredient(null, "Биокотлета из марсианской Магнолии", 424));

        burger.moveIngredient(0, 1);

        Assert.assertEquals("Биокотлета из марсианской Магнолии", burger.ingredients.get(0).name);
        Assert.assertEquals("Соус Spicy-X", burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceCheck() {
        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Assert.assertEquals(300f, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptCheck() {
        Bun bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус фирменный Space Sauce");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);

        Assert.assertEquals(EXPECTED_RECEIPT, burger.getReceipt());
    }

}
