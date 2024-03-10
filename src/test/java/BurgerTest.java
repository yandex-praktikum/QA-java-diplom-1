import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Test
    public void testGetPrice(){
        Bun bun = new Bun("FluBun", 0.50f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "GalacticSauce", 1.50f);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "ShellfishMeat", 1.80f );
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        assertEquals(0.50f + 0.50f + 1.50f + 1.80f, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        Bun bun = new Bun("FluBun", 0.50f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "SpicyX", 1.70f);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Magnolia", 2.10f );
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        String expectedReceipt = "(==== FluBun ====)\n" +
                "= sauce SpicyX =\n" +
                "= filling Magnolia =\n" +
                "(==== FluBun ====)\n" +
                "\n" +
                "Price: 4,800000\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        Ingredient mockIngredient1 = Mockito.mock(Ingredient.class);
        Ingredient mockIngredient2 = Mockito.mock(Ingredient.class);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        Mockito.lenient().when(mockIngredient1.getName()).thenReturn("MockIngredient1");
        Mockito.lenient().when(mockIngredient2.getName()).thenReturn("MockIngredient2");

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertEquals("MockIngredient2", burger.ingredients.get(0).getName());
    }
}






