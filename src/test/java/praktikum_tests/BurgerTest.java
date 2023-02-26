package praktikum_tests;


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
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    private Bun mockedBun;

    @Mock
    private Ingredient mockedIngredient;
    private Ingredient mockedIngredient2;


    @Test
    public void checkSetBunMethod() {
        burger.setBuns(mockedBun);
        assertEquals("setBun method returns mocked bun", mockedBun, burger.bun);
    }

    @Test
    public void checkAddIngredientMethod() {
        burger.addIngredient(mockedIngredient);
        assertEquals("addIngredient method adds mocked ingredient",List.of(mockedIngredient), burger.ingredients);
    }

    @Test
    public void checkRemoveIngredientMethod() {
        burger.addIngredient(mockedIngredient);
        burger.removeIngredient(0);
        assertTrue("removeIngredient method removes the ingredient", burger.ingredients.isEmpty());

    }

    @Test
    public void checkMoveIngredientMethod() {

        burger.addIngredient(mockedIngredient);
        burger.addIngredient(mockedIngredient2);

        burger.moveIngredient(0, 1);

        Assert.assertEquals("moveIngredient method moves the ingredient",mockedIngredient2, burger.ingredients.get(0));


    }

    @Test
    public void checkGetPriceMethod() {
        burger.setBuns(mockedBun);
        burger.addIngredient(mockedIngredient);
        Mockito.when(mockedBun.getPrice()).thenReturn(300f);
        Mockito.when(mockedIngredient.getPrice()).thenReturn(300f);

        float expectedPrice = 900f;

        Assert.assertEquals("Mocked method getPrice returns price",expectedPrice, burger.getPrice(), 0);

    }

    @Test
    public void checkGetReceiptMethod() {
        burger.setBuns(mockedBun);
        burger.addIngredient(mockedIngredient);

        Mockito.when(mockedBun.getName()).thenReturn("Test Bun Name");
        Mockito.when(mockedBun.getPrice()).thenReturn(300f);

        Mockito.when(mockedIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockedIngredient.getName()).thenReturn("Test Ingredient Name");
        Mockito.when(mockedIngredient.getPrice()).thenReturn(300f);

        assertEquals("Mocked method getReceipt returns receipt",String.format("(==== %s ====)%n", mockedBun.getName()) +
                String.format("= %s %s =%n", mockedIngredient.getType().toString().toLowerCase(), mockedIngredient.getName()) +
                String.format("(==== %s ====)%n", mockedBun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice()), burger.getReceipt());

    }


}
