import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTest {
    Burger burger = new Burger();

    Bun bun = Mockito.mock(Bun.class);
    Ingredient ingredient = Mockito.mock(Ingredient.class);

    @Test
    public void testGetPriceForBurger() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        float expected = 300;
        assertEquals("Получена некорректная цена для бургера",expected, actual, 0);
    }

    @Test
    public void testGetReceiptForBurger() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(burger.getPrice()).thenReturn(Float.valueOf("500"));
        String actual = burger.getReceipt();
        String expected = "(==== black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "(==== black bun ====)\n"
                + "\n" + "Price: 500.000000" + "\n";
        assertEquals("Получен некорректный чек", expected, actual);
    }

}
