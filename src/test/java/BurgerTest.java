import org.junit.After;
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

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger buterbrod;
    @Mock
    private Bun toast;
    @Mock
    private Ingredient cheese;
    @Mock
    private Ingredient salad;
    @Mock
    private Ingredient tomato;

    @Before
    public void newBurger() {
        buterbrod = new Burger();
        buterbrod.setBuns(toast);
        buterbrod.addIngredient(cheese);
        buterbrod.addIngredient(salad);
        buterbrod.addIngredient(tomato);
    }

    @After
    public void clearData() {
        buterbrod.ingredients.clear();
    }

    @Test
    public void setBunsChooseCorrectBun() {
        assertEquals(buterbrod.bun, toast);
    }

    @Test
    public void addIngredientCorrectAddedInList() {
        assertTrue(buterbrod.ingredients.contains(cheese));
    }

    @Test
    public void removeIngredientCorrectRemove() {
        buterbrod.removeIngredient(0);
        assertFalse(buterbrod.ingredients.contains(cheese));
    }

    @Test
    public void moveIngredientCorrectMove() {
        buterbrod.moveIngredient(0, 2);
        assertEquals(cheese, buterbrod.ingredients.get(2));
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        Mockito.doReturn(100F).when(toast).getPrice();
        Mockito.doReturn(50F).when(cheese).getPrice();
        Mockito.doReturn(40F).when(salad).getPrice();
        Mockito.doReturn(60F).when(tomato).getPrice();
        assertEquals(350, buterbrod.getPrice(), 0);
    }

    @Test
    public void getReceiptReturnCorrectValues() {
        Mockito.doReturn("harrys").when(toast).getName();
        Mockito.doReturn(100F).when(toast).getPrice();
        Mockito.doReturn(IngredientType.FILLING).when(cheese).getType();
        Mockito.doReturn("Сыр").when(cheese).getName();
        Mockito.doReturn(50F).when(cheese).getPrice();
        Mockito.doReturn(IngredientType.FILLING).when(salad).getType();
        Mockito.doReturn("Салат").when(salad).getName();
        Mockito.doReturn(40F).when(salad).getPrice();
        Mockito.doReturn(IngredientType.FILLING).when(tomato).getType();
        Mockito.doReturn("Помидорка").when(tomato).getName();
        Mockito.doReturn(60F).when(tomato).getPrice();
        String receipt =
                "(==== harrys ====)\n"+
                        "= filling Сыр =\n"+
                        "= filling Салат =\n"+
                        "= filling Помидорка =\n"+
                        "(==== harrys ====)\n"+
                        "\n"+
                        "Price: 350,000000\n";
        assertEquals("Неверный рецепт", receipt, buterbrod.getReceipt());

    }
}
