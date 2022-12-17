package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest extends BaseTestData{

    @Mock
    Bun mockBun;
    @Mock
    Ingredient filling;
    @Mock
    Ingredient sauce;
    Burger burger = new Burger();

    @Test
    public void setBuns() {
        burger.setBuns(mockBun);
        burger.bun.getName();
        Mockito.verify(mockBun).getName();
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(filling);
        burger.ingredients.get(0).getName();
        Mockito.verify(filling).getName();
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.removeIngredient(0);
        burger.ingredients.get(0).getName();
        Mockito.verify(sauce).getName();
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(0,1);
        burger.ingredients.get(0).getName();
        Mockito.verify(sauce).getName();
    }

    @Test
    public void getReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        Mockito.when(mockBun.getName()).thenReturn(testBunName);
        Mockito.when(filling.getName()).thenReturn(testFillingName);
        Mockito.when(sauce.getName()).thenReturn(testSauceName);
        Mockito.when(mockBun.getPrice()).thenReturn(testBunPrice);
        Mockito.when(filling.getPrice()).thenReturn(testFillingPrice);
        Mockito.when(sauce.getPrice()).thenReturn(testSaucePrice);
        Mockito.when(filling.getPrice()).thenReturn(testFillingPrice);
        Mockito.when(sauce.getPrice()).thenReturn(testSaucePrice);
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);

        burger.getReceipt();
        Mockito.verify(mockBun, Mockito.times(2)).getName();
        Mockito.verify(filling).getName();
        Mockito.verify(filling).getType();
        Mockito.verify(sauce).getName();
        Mockito.verify(sauce).getType();
    }
}