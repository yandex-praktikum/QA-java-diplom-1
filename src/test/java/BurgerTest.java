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

    private Burger burger;

    @Before
    public void setup() {
        burger = new Burger();
    }

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Test
    public void setBunTest() {
        burger.setBuns(bun);

        Assert.assertEquals("setBuns's method error, class 'burger'", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        int expectedSize = burger.ingredients.size() + 1;

        burger.addIngredient(ingredient1);
        int actualSize = burger.ingredients.size();

        Assert.assertEquals("addIngredient's method error, class 'burger'", expectedSize, actualSize);
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient1);
        int expectedSize = burger.ingredients.size() - 1;

        burger.removeIngredient(0);
        int actualSize = burger.ingredients.size();

        Assert.assertEquals("removeIngredient's method error, class 'burger'", expectedSize, actualSize);
    }

    @Test
    public void moveIngredientTest() {
        ingredient1 = new Ingredient(IngredientType.FILLING, "Мясо", 10);
        ingredient2 = new Ingredient(IngredientType.SAUCE, "Чили", 2);

        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);

        burger.moveIngredient(0, 1);

        Object expectedIngredient = ingredient1;
        Object actualIngredient = burger.ingredients.get(1);

        Assert.assertEquals("removeIngredient's method error, class 'burger'", expectedIngredient, actualIngredient);
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void getPriceTest() {
        float mockBunPrice = 1;
        float mockIngredient1Price = 2;
        float mockIngredient2Price = 3;

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getPrice()).thenReturn(mockBunPrice);
        Mockito.when(ingredient1.getPrice()).thenReturn(mockIngredient1Price);
        Mockito.when(ingredient2.getPrice()).thenReturn(mockIngredient2Price);

        float expectedPrice = 7;
        float actualPrice = burger.getPrice();

        Assert.assertEquals("getPrice's method error, class 'burger'", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptTest() {
        String mockBunName = "Булочка с корицей";
        IngredientType mockIngredient1Type = IngredientType.SAUCE;
        IngredientType mockIngredient2Type = IngredientType.FILLING;
        String mockIngredient1Name = "Хот-чили";
        String mockIngredient2Name = "Говяжья котлетка";
        float burgerPrice = 300;

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getName()).thenReturn(mockBunName);
        Mockito.when(ingredient1.getType()).thenReturn(mockIngredient1Type);
        Mockito.when(ingredient2.getType()).thenReturn(mockIngredient2Type);
        Mockito.when(ingredient1.getName()).thenReturn(mockIngredient1Name);
        Mockito.when(ingredient2.getName()).thenReturn(mockIngredient2Name);
        Mockito.when(ingredient2.getName()).thenReturn(mockIngredient2Name);
        Mockito.when(burger.getPrice()).thenReturn(burgerPrice);

        String expectedReceipt = "(==== Булочка с корицей ====)\r\n" +
                "= sauce Хот-чили =\r\n" +
                "= filling Говяжья котлетка =\r\n" +
                "(==== Булочка с корицей ====)\r\n" +
                "\r\n" +
                "Price: 300,000000\r\n";

        String actualReceipt = burger.getReceipt();

        Assert.assertEquals("getReceipt's method error, class 'burger'", expectedReceipt, actualReceipt);
    }
}
