import praktikum.Ingredient;
import praktikum.IngredientType;
import praktikum.Burger;
import praktikum.Bun;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();
    Bun bun = Mockito.spy(new Bun("black bun", 100f));
    Ingredient ingredient1 = Mockito.spy(new Ingredient(IngredientType.SAUCE, "hot sauce", 100f));
    Ingredient ingredient2 = Mockito.spy(new Ingredient(IngredientType.FILLING, "dinosaur", 200f));

    @Test
    public void shouldReturnBurgerPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(100f);

        float expectedBurgerPrice = 300f;

        assertEquals(expectedBurgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void shouldReturnBurgerReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("dinosaur");

        String expectedReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
