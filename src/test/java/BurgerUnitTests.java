
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerUnitTests {
    private final Burger burger = new Burger();
    @Mock
    Ingredient ingredientSauce;
    @Mock
    Ingredient ingredientFilling;
    @Mock
    Database database;
    private final List<Bun> buns = Arrays.asList(new Bun("red bun",400.00F));

    private final String bunName = "red bun";
    @Before
    public void setDefaultBun() {

        Mockito.when(database.availableBuns()).thenReturn(buns);
    }

    @Test
    public void checkSetBuns() {
        burger.setBuns(database.availableBuns().get(0));
        assertEquals(bunName, burger.bun.getName());
    }

    @Test
    public void checkGetPrice() {
        Mockito.when(ingredientSauce.getPrice()).thenReturn(200F);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(200F);
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        float expectedBurgerPrice = 1200.0F;
        assertEquals("Цена указанa неверно", expectedBurgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceipt() {
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn("sour cream");
        Mockito.when(ingredientSauce.getPrice()).thenReturn(200F);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFilling.getName()).thenReturn("dinosaur");
        Mockito.when(ingredientFilling.getPrice()).thenReturn(200F);
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        String expected = "(==== red bun ====)" + "\n"
                + "= sauce sour cream =" + "\n"
                + "= filling dinosaur =" + "\n"
                + "(==== red bun ====)" + "\n\n"
                + "Price: 1200,000000" + "\n";
        assertEquals(expected, burger.getReceipt());
    }
}
