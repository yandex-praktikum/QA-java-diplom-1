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


@RunWith(MockitoJUnitRunner.class)
public class BurgerMockStubTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    private Burger burger = new Burger();
    //private Burger burger = new Burger();

    @Before
    public void setUp(){
        //stub для bun
        Mockito.when(bun.getName()).thenReturn("first bun").thenReturn("second bun");
        Mockito.when(bun.getPrice()).thenReturn(500F).thenReturn(1000F);

        //stub для ingredient
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("ketchup").thenReturn("mustard");
        Mockito.when(ingredient.getPrice()).thenReturn(100F).thenReturn(150F);

        // creating burger with ingredients
        burger.addIngredient(new Ingredient(
                ingredient.getType(),
                ingredient.getName(),
                ingredient.getPrice()));
        // set bun
        burger.setBuns(bun);
    }

    @Test
    public void setBun() {
        // Check for created burger.bun when call setBuns(bun)
        assertEquals(burger.bun, bun);
    }

    @Test
    public void addIngredient() {
        // Check for added two ingredient when call addIngredient()
        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.size(), 2);
    }

    @Test
    public void removeIngredient() {
        // Check for remove one ingredient when call removeIngredient()
        burger.addIngredient(ingredient);
         burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(), 1);
    }

    @Test
    public void moveIngredient() {
        // Check for move one ingredient on place two ingredient when call moveIngredient()
        burger.addIngredient(new Ingredient(
                ingredient.getType(),
                ingredient.getName(),
                ingredient.getPrice()));
        assertEquals("mustard", burger.ingredients.get(1).name);
    }

    @Test
    public void getPrice() {
        // Check first price [500*2 + 100]
        assertEquals(1100, burger.getPrice(),0);
        // Check second price [1000*2 + 100 + 150]
        burger.addIngredient(ingredient);
        assertEquals(2250, burger.getPrice(),0);
    }

    @Test
    public void getReceipt() {
        // Check receipt for first burger
        String receipt = burger.getReceipt();

        String expectedResult = "" +
                "(==== first bun ====)\r\n" +
                "= sauce ketchup =\r\n" +
                "(==== second bun ====)\r\n" +
                "\r\n" +
                "Price: 1100,000000\r\n" ;
        assertEquals(expectedResult, receipt);
    }
}
