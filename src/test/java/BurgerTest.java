import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredientSecond;

    Burger burger = new Burger();

    @Before
    public void setUp() {

    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        for (int i = 1; i < 5; i++) {
            burger.addIngredient(ingredient);
        }
        Assert.assertEquals(4, burger.ingredients.stream().count());
    }

    @Test
    public void delIngredientTest() {
        for (int i = 1; i < 5; i++) {
            burger.addIngredient(ingredient);
        }
        burger.removeIngredient(1);
        Assert.assertEquals(3, burger.ingredients.stream().count());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(burger.ingredients.get(0), ingredientSecond);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Mockito.when(ingredient.getPrice()).thenReturn(4f);
        burger.setBuns(bun);
        for (int i = 1; i < 3; i++) {
            burger.addIngredient(ingredient);
        }
        Assert.assertEquals(12.00F, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Начинка");
        Mockito.when(burger.getPrice()).thenReturn(12F);

        String expected =
                "(==== Булка ====)\r\n" +
                        "= filling Начинка =\r\n" +
                        "(==== Булка ====)\r\n" +
                        "\r\n" +
                        "Price: 12,000000\r\n";
        Assert.assertEquals("Ошибка в чеке", expected, burger.getReceipt());
    }
}
