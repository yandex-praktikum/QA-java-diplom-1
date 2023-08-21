import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ketchup;
    @Mock
    Ingredient patty;

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ketchup);

        int unexpected = -1;
        int actual = burger.ingredients.indexOf(ketchup);

        assertNotEquals(unexpected, actual);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ketchup);
        burger.removeIngredient(0);

        int expected = -1;
        int actual = burger.ingredients.indexOf(ketchup);

        assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ketchup);
        burger.addIngredient(patty);
        burger.moveIngredient(1, 0);

        int expected = 0;
        int actual = burger.ingredients.indexOf(patty);

        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ketchup);
        burger.addIngredient(patty);


        Mockito.when(bun.getPrice()).thenReturn(10.0F);
        Mockito.when(ketchup.getPrice()).thenReturn(90.0F);
        Mockito.when(patty.getPrice()).thenReturn(20.0F);

        float expected = 130.0F;
        float actual = burger.getPrice();

        assertEquals(expected, actual, 0.0F);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ketchup);
        burger.addIngredient(patty);

        Mockito.when(bun.getName()).thenReturn("Бриош");
        Mockito.when(ketchup.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ketchup.getName()).thenReturn("Кенчуп");
        Mockito.when(patty.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(patty.getName()).thenReturn("Коклета");

        String expected = String.format("(==== %s ====)%n", bun.getName()) + String.format("= %s %s =%n", ketchup.getType().toString().toLowerCase(),
                ketchup.getName()) +
                String.format("= %s %s =%n", patty.getType().toString().toLowerCase(),
                        patty.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        String actual = burger.getReceipt();

        assertEquals(expected, actual);
    }
}
