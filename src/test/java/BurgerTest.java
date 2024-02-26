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
public class BurgerTest {

    private final Burger burger = new Burger();
    @Mock
    Database database;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientTwo;

    private final List<Bun> buns = Arrays.asList(new Bun("black bun", 100.0F));
    private final String bunName = "black bun";

    @Before
    public void setUp(){
        Mockito.when(database.availableBuns()).thenReturn(buns);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
    }

    @Test
    public void setBurgerTest(){
        burger.setBuns(database.availableBuns().get(0));
        assertEquals(bunName, burger.bun.getName());
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(database.availableBuns().get(0));

        Mockito.when(ingredient.getPrice()).thenReturn(10F);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(10F);

        float result = burger.getPrice();
        float expected = 220.0F;
        assertEquals("Неверный расчет стоимости бургера", expected, result, 0);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(database.availableBuns().get(0));

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientTwo.getName()).thenReturn("cutlet");

        String result = burger.getReceipt();
        String expected = "(==== black bun ====)\r\n"
                +"= sauce hot sauce =\r\n"
                +"= filling cutlet =\r\n"
                +"(==== black bun ====)\r\n\r\n"
                +"Price: 200,000000\r\n";
        assertEquals("Неверный формат или неверные данные в чеке", expected, result);
    }

    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        burger.moveIngredient(0, 1);
        assertEquals(1, burger.ingredients.indexOf(ingredient));
    }
}
