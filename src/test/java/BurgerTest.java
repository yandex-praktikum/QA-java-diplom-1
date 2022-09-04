package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Mock
    Ingredient ingredient3;

    Burger burger = new Burger();

    @Test
    public void shouldSetBunInBurger(){
        burger.setBuns(bun);
        assertEquals(burger.bun, bun);
    }

    @Test
    public void shouldAddIngredientsInBurger(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(burger.ingredients, List.of(ingredient1, ingredient2, ingredient3));
    }

    @Test
    public void shouldRemoveIngredientsInBurger(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.removeIngredient(1);
        assertEquals(burger.ingredients, List.of(ingredient1, ingredient3));
    }

    @Test
    public void shouldMoveIngredientsInBurger(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(2, 0);
        assertEquals(burger.ingredients, List.of(ingredient3, ingredient1, ingredient2));
    }

    @Test
    public void shouldGetPriceBurger(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        Mockito.when(bun.getPrice()).thenReturn(150.55f);
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);
        Mockito.when(ingredient2.getPrice()).thenReturn(99.85f);
        Mockito.when(ingredient3.getPrice()).thenReturn(43.25f);

        assertEquals(burger.getPrice(), 494.2f, 0.0);
    }

    @Test
    public void shouldGetReceiptBurger(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        Mockito.when(bun.getName()).thenReturn("Ржаная с кунжутом");
        Mockito.when(bun.getPrice()).thenReturn(150.55f);
        Mockito.when(ingredient1.getName()).thenReturn("Кепчуп");
        Mockito.when(ingredient2.getName()).thenReturn("Катлетка");
        Mockito.when(ingredient3.getName()).thenReturn("Салатик");
        Mockito.when(ingredient1.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient2.getType()).thenReturn(FILLING);
        Mockito.when(ingredient3.getType()).thenReturn(FILLING);
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);
        Mockito.when(ingredient2.getPrice()).thenReturn(99.85f);
        Mockito.when(ingredient3.getPrice()).thenReturn(43.25f);

        String expectedReceipt = "(==== Ржаная с кунжутом ====)\r\n" +
                "= sauce Кепчуп =\r\n" +
                "= filling Катлетка =\r\n" +
                "= filling Салатик =\r\n" +
                "(==== Ржаная с кунжутом ====)\r\n" +
                "\r\n" +
                "Price: 494,200012\r\n";

        assertEquals(burger.getReceipt(), expectedReceipt);
    }
}