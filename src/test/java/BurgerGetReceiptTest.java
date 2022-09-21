import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.assertEquals;

public class BurgerGetReceiptTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    Burger burger;
    @Mock
    Ingredient ingredient_1;
    @Mock
    Ingredient ingredient_2;
    @Mock
    Ingredient ingredient_3;
    @Mock
    Bun bun;

    @Test
    public void getReceiptReturnsCorrectReceipt() {
        burger.bun = bun;
        burger.ingredients.add(ingredient_1);
        burger.ingredients.add(ingredient_2);
        burger.ingredients.add(ingredient_3);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(burger.getPrice()).thenReturn(10000F);

        Mockito.when(ingredient_1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient_1.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient_2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient_2.getName()).thenReturn("cutlet");
        Mockito.when(ingredient_3.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient_3.getName()).thenReturn("sausage");
        String expected = "(==== black bun ====)"+lineSeparator()+"= sauce chili sauce ="+ lineSeparator()+"= filling cutlet ="+ lineSeparator()+"= filling sausage ="+ lineSeparator()+"(==== black bun ====)"+ lineSeparator()+ lineSeparator()+"Price: 10000,000000"+ lineSeparator();

        String actual = burger.getReceipt();

        assertEquals("Returns incorrect receipt string", expected, actual);
    }
}
