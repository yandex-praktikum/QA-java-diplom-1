import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @InjectMocks
    private Burger burger;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        bun = Mockito.mock(Bun.class);
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    @Description("Можно изменить порядок ингредиента")
    public void testMoveIngredient() {
        Ingredient otherIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(otherIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(otherIngredient, burger.ingredients.get(0));
        assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    @Description("Можно получить цену бургера")
    public void testGetPrice() {
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);

        float expectedPrice = burger.bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    @Description("Можно получить состав бургера")
    public void testGetReceipt() {
        Mockito.when(ingredient.getName()).thenReturn("MockIngredient");
        Mockito.when(bun.getName()).thenReturn("MockBun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        burger.addIngredient(ingredient);
        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                burger.bun.getName(),
                ingredient.getType().toString().toLowerCase(),
                ingredient.getName(),
                burger.bun.getName(),
                burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}