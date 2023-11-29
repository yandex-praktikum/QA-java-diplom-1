package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @InjectMocks
    private Burger burger;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Mock
    private Bun bun;

    private static final String BUN_NAME = "булочка с кунжутом";
    private static final String INGREDIENT1_NAME = "котлета";
    private static final String INGREDIENT2_NAME = "кетчуп";

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient1);
        int one = 1;
        Assert.assertEquals(one, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        int zero = 0;
        Assert.assertEquals(zero, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);

        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient1.getPrice()).thenReturn(20F);
        Mockito.when(ingredient2.getPrice()).thenReturn(30F);

        Assert.assertEquals(70F, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        String expectedReceipt = "(==== " + BUN_NAME + " ====)\r\n" +
                "= filling " + INGREDIENT1_NAME + " =\r\n" +
                "= sauce " + INGREDIENT2_NAME + " =\r\n" +
                "(==== " + BUN_NAME + " ====)\r\n\r\n" +
                "Price: 0,000000\r\n";

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredient1.getName()).thenReturn(INGREDIENT1_NAME);
        Mockito.when(ingredient2.getName()).thenReturn(INGREDIENT2_NAME);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
