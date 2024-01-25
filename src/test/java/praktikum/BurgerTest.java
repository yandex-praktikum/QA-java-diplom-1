package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    Burger burger = new Burger();

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);

        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(0, 1);
        assertEquals(1, burger.ingredients.indexOf(firstIngredient));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);

        when(firstIngredient.getPrice()).thenReturn(999f);
        when(secondIngredient.getPrice()).thenReturn(1f);
        when(bun.getPrice()).thenReturn(10f);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        assertEquals(1020.0f, burger.getPrice());
    }

    @Test
    public void getReceiptTest() {
        when(bun.getName()).thenReturn("Bun");
        when(bun.getPrice()).thenReturn(10f);

        when(firstIngredient.getName()).thenReturn("Две мясных собаки гриль");
        when(firstIngredient.getPrice()).thenReturn(100f);
        when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);

        when(secondIngredient.getName()).thenReturn("Специальный тухлый сыр");
        when(secondIngredient.getPrice()).thenReturn(100f);
        when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(bun);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        assertEquals(
                "(==== Bun ====)\r\n" +
                        "= filling Две мясных собаки гриль =\r\n" +
                        "= filling Специальный тухлый сыр =\r\n" +
                        "(==== Bun ====)\r\n" +
                        "\r\n" +
                        "Price: 220,000000\r\n",
                burger.getReceipt()
        );
    }
}
