import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {



    Burger burger = new Burger();

    @Mock
    Ingredient cutlet;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient salad;
    @Mock
    Bun bun;

    @Before
    public void beforeMethod() {
        burger.addIngredient(cutlet);
        burger.addIngredient(cheese);
        burger.addIngredient(salad);
    }

    @After
    public void afterTest() {
        burger.ingredients.clear();
    }


    @Test
    public void addIngredientTest(){
        assertEquals(List.of(cutlet, cheese, salad), burger.ingredients);
    }

    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(1);
        assertEquals(List.of(cutlet, salad), burger.ingredients);
    }

    @Test
    public void moveIngredientTest(){
        burger.moveIngredient(2, 0);
        assertEquals(List.of(salad, cutlet, cheese), burger.ingredients);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(0.954f);
        Mockito.when(cutlet.getPrice()).thenReturn(2.876f);
        Mockito.when(cheese.getPrice()).thenReturn(2.154f);
        Mockito.when(salad.getPrice()).thenReturn(0.732f);
        assertEquals(7.670f, burger.getPrice(), 0.0001f);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("wheat");
        Mockito.when(bun.getPrice()).thenReturn(0.954f);
        Mockito.when(cutlet.getPrice()).thenReturn(2.876f);
        Mockito.when(cheese.getPrice()).thenReturn(2.154f);
        Mockito.when(salad.getPrice()).thenReturn(0.732f);
        Mockito.when(cutlet.getType()).thenReturn(FILLING);
        Mockito.when(cheese.getType()).thenReturn(SAUCE);
        Mockito.when(salad.getType()).thenReturn(FILLING);
        Mockito.when(cutlet.getName()).thenReturn("котлета");
        Mockito.when(cheese.getName()).thenReturn("сыр");
        Mockito.when(salad.getName()).thenReturn("салат");
        System.out.println(burger.getReceipt());
        assertEquals("(==== wheat ====)\r\n" +
                "= filling котлета =\r\n" +
                "= sauce сыр =\r\n" +
                "= filling салат =\r\n" +
                "(==== wheat ====)\r\n" +
                "\r\n" +
                "Price: 7,670000\r\n", burger.getReceipt());
    }
}
