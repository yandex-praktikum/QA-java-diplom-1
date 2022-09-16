import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;

@RunWith(value = JUnitParamsRunner.class)
public class BurgerParamTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setup() throws Exception {
        openMocks(this).close();
    }

    public Iterable getParameters() {
        return Arrays.asList(new Object[][]{
                {"black bun", "hot sauce", IngredientType.SAUCE, 700F},
                {"white bun", "sour cream", IngredientType.SAUCE, 600F},
                {"red bun", "chili sauce", IngredientType.SAUCE, 900F},
                {"black bun", "cutlet", IngredientType.FILLING, 700F},
                {"white bun", "dinosaur", IngredientType.FILLING, 600F},
                {"red bun", "sausage", IngredientType.FILLING, 900F},
        });
    }

    @Test
    @Parameters(method = "getParameters")
    public void getReceiptTest(String buns, String ingredients, IngredientType type, float price) {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(buns);
        Mockito.when(ingredient.getName()).thenReturn(ingredients);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(burger.getPrice()).thenReturn(price);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", buns));
        receipt.append(String.format("= %s %s =%n", type.toString().toLowerCase(), ingredients));
        receipt.append(String.format("(==== %s ====)%n", buns));
        receipt.append(String.format("%nPrice: %f%n", price));
        assertEquals(String.format("Метод должен возвращать строку c %s, %s %s и ценой %s", buns, type, ingredients, price), receipt.toString(), burger.getReceipt());
    }
}