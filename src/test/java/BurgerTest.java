import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient SauceMock;
    @Mock
    private Ingredient FillingMock;

    @Before
    public void start() {
        MockitoAnnotations.initMocks(this);
        when(bunMock.getName()).thenReturn("step");
        when(bunMock.getPrice()).thenReturn(1f);
        when(SauceMock.getType()).thenReturn(IngredientType.SAUCE);
        when(SauceMock.getName()).thenReturn("hot");
        when(SauceMock.getPrice()).thenReturn(2f);
        when(FillingMock.getType()).thenReturn(IngredientType.FILLING);
        when(FillingMock.getName()).thenReturn("cutlet");
        when(FillingMock.getPrice()).thenReturn(3f);
        burger = new Burger();
        burger.setBuns(bunMock);
        burger.setBuns(bunMock);
        burger.addIngredient(SauceMock);
        burger.addIngredient(FillingMock);
    }

    @Test
    public void testGetPrice() {
        assertEquals(7f, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetRecipe() {
        String expectedReceipt = String.format(
                "(==== step ====)%n" +
                        "= sauce hot =%n" +
                        "= filling cutlet =%n" +
                        "(==== step ====)%n" +
                        "%nPrice: 7,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }
    @Test
    public void testAddIngredient() {
        burger.addIngredient(SauceMock);
        burger.addIngredient(FillingMock);

        String expectedReceipt = String.format(
                "(==== step ====)%n" +
                        "= sauce hot =%n" +
                        "= filling cutlet =%n" +
                        "= sauce hot =%n" +
                        "= filling cutlet =%n" +
                        "(==== step ====)%n" +
                        "%n" +
                        "Price: 12,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }
    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(0, 1);

        String expectedReceipt = String.format(
                "(==== step ====)%n" +
                        "= filling cutlet =%n" +
                        "= sauce hot =%n" +
                        "(==== step ====)%n" +
                        "%n" +
                        "Price: 7,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }
    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(1);
        burger.removeIngredient(0);

        String expectedReceipt = String.format(
                "(==== step ====)%n" +
                        "(==== step ====)%n" +
                        "%n" +
                        "Price: 2,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}