import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    private Burger burger;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Bun bun;
    @Mock
    Burger burgerMock = new Burger();
    @Before
    public void setUp(){
        burger = new Burger();
    }
    @Test
    public void testSetBuns(){
        burgerMock.setBuns(burgerMock.bun);
        Mockito.verify(burgerMock).setBuns(burgerMock.bun);
    }
    @Test
    public void testAddIngredient(){
        burger.addIngredient(ingredient);
        assertEquals(ingredient,burger.ingredients.get(0));
    }
    @Test
    public void testRemoveIngredient(){
        List<Ingredient> expected = new ArrayList<>();

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(expected,burger.ingredients);
    }
    @Test
    public void testMoveIngredient(){
        burger.addIngredient(new Ingredient(SAUCE,"Чили",12.99f));
        burger.addIngredient(new Ingredient(FILLING,"Кепчук",12.99f));
        burger.moveIngredient(0,1);

        assertEquals("Чили",burger.ingredients.get(1).name);
    }
    @Test
    public void testGetPrice(){
        float price = 12.99f;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals(38.97f,burger.getPrice(),0);
    }
    @Test
    public void testGetReceipt(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

            Mockito.when(bun.getName()).thenReturn("Булка");
            Mockito.when(bun.getPrice()).thenReturn(12.99f);
            Mockito.when(ingredient.getType()).thenReturn(SAUCE);
            Mockito.when(ingredient.getName()).thenReturn("Кепчук");
            Mockito.when(ingredient.getPrice()).thenReturn(12.99f);

            String expected ="(==== Булка ====)" +"\r\n" + "= sauce Кепчук =" +"\r\n"+"(==== Булка ====)"+"\r\n"+"\r\n"+"Price: 38,970001"+"\r\n";

            assertEquals(expected,burger.getReceipt());
    }
}