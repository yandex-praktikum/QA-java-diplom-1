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
    Ingredient dinosaur;
    @Mock
    Ingredient sausage;
    @Mock
    Bun bun;

    @Before
    public void beforeMethod() {
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);
        burger.addIngredient(sausage);
    }

    @After
    public void afterTest() {
        burger.ingredients.clear();
    }


    @Test
    public void addIngredientTest(){
        assertEquals(List.of(cutlet, dinosaur, sausage), burger.ingredients);
    }

    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(1);
        assertEquals(List.of(cutlet, sausage), burger.ingredients);
    }

    @Test
    public void moveIngredientTest(){
        burger.moveIngredient(2, 0);
        assertEquals(List.of(sausage, cutlet, dinosaur), burger.ingredients);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(cutlet.getPrice()).thenReturn(100f);
        Mockito.when(dinosaur.getPrice()).thenReturn(200f);
        Mockito.when(sausage.getPrice()).thenReturn(300f);
        assertEquals(800f, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("wheat");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(cutlet.getPrice()).thenReturn(100f);
        Mockito.when(dinosaur.getPrice()).thenReturn(200f);
        Mockito.when(sausage.getPrice()).thenReturn(300f);
        Mockito.when(cutlet.getType()).thenReturn(FILLING);
        Mockito.when(dinosaur.getType()).thenReturn(SAUCE);
        Mockito.when(sausage.getType()).thenReturn(FILLING);
        Mockito.when(cutlet.getName()).thenReturn("cutlet");
        Mockito.when(dinosaur.getName()).thenReturn("dinosaur");
        Mockito.when(sausage.getName()).thenReturn("sausage");
        System.out.println(burger.getReceipt());
        assertEquals("(==== wheat ====)\r\n" +
                "= filling cutlet =\r\n" +
                "= sauce dinosaur =\r\n" +
                "= filling sausage =\r\n" +
                "(==== wheat ====)\r\n" +
                "\r\n" +
                "Price: 800,000000\r\n", burger.getReceipt());
    }
}
