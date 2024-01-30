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
import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void setBunsWithStab() {
        Mockito.lenient().when(bunMock.getName()).thenReturn("Vol bun");
        Mockito.lenient().when(bunMock.getPrice()).thenReturn(123f);
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredientWithStab() {
        Mockito.lenient().when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.lenient().when(ingredientMock.getName()).thenReturn("RedHotChiliPeppers");
        Mockito.lenient().when(ingredientMock.getPrice()).thenReturn(0.01f);
        burger.addIngredient(ingredientMock);
        assertEquals(ingredientMock, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientWithStab() {
        Mockito.lenient().when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.lenient().when(ingredientMock.getName()).thenReturn("Vader sauce");
        Mockito.lenient().when(ingredientMock.getPrice()).thenReturn(9876f);
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientWithStab() {
        Ingredient secondIngredientMock = mock(Ingredient.class);
        Mockito.lenient().when(ingredientMock.getPrice()).thenReturn(3.14f);
        Mockito.when(ingredientMock.getName()).thenReturn("sdgfghdj");
        Mockito.lenient().when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.lenient().when(secondIngredientMock.getPrice()).thenReturn(0.14f);
        Mockito.lenient().when(secondIngredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.lenient().when(secondIngredientMock.getName()).thenReturn("Interstellar");
        burger.addIngredient(ingredientMock);
        burger.addIngredient(secondIngredientMock);
        burger.moveIngredient(0,1);
        assertEquals("sdgfghdj", burger.ingredients.get(1).getName());

    }

    @Test
    public void getPrice() {
        Mockito.lenient().when(bunMock.getName()).thenReturn("WTF");
        Mockito.when(bunMock.getPrice()).thenReturn(300f);
        Mockito.lenient().when(ingredientMock.getName()).thenReturn("Cheese sauce");
        Mockito.when(ingredientMock.getPrice()).thenReturn(100f);
        Mockito.lenient().when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        float actual = burger.getPrice();
        assertEquals(700, actual, 0);
    }

    @Test
    public void getReceipt() {
        Mockito.when(bunMock.getName()).thenReturn("VOLK AUF");
        Mockito.when(bunMock.getPrice()).thenReturn(300f);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientMock.getName()).thenReturn("bbq sauce");
        Mockito.when(ingredientMock.getPrice()).thenReturn(100f);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        String actual = burger.getReceipt();
        String expected = String.format("(==== VOLK AUF ====)%n" +
                "= sauce bbq sauce =%n" +
                "(==== VOLK AUF ====)%n" +
                "%n" +
                "Price: 700,000000%n");
        assertEquals(expected, actual);
    }
}