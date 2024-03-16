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
    float fluBunPrice = 0.50f;
    float galacticSaucePrice = 1.50f;
    float shellfishMeatPrice = 1.80f;
    float SpicyXPrice = 1.70f;
    float MagnoliaPrice = 2.10f;
    @Test
    public void testGetPrice(){
        Bun bun = new Bun("FluBun", fluBunPrice);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "GalacticSauce", galacticSaucePrice);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "ShellfishMeat", shellfishMeatPrice );
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        assertEquals(fluBunPrice + fluBunPrice + galacticSaucePrice + shellfishMeatPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        Bun bun = new Bun("FluBun", fluBunPrice);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "SpicyX", SpicyXPrice);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Magnolia", MagnoliaPrice );
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






