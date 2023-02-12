import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger = new Burger();
    @Mock
    Bun testBun;
    @Mock
    Ingredient testIngredient,testIngredient1,testIngredient2;

    @Test
    public void setBunSetsTrueValue(){
        burger.setBuns(testBun);

        when(testBun.getName()).thenReturn("testBun");

        assertEquals("testBun",burger.bun.getName());
    }

    @Test
    public void setIngredientAddsTrueValue(){
        burger.addIngredient(testIngredient);

        when(testIngredient.getName()).thenReturn("testIngredient");

        assertEquals("testIngredient",burger.ingredients.get(burger.ingredients.size() - 1).getName());
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(testIngredient);
        burger.addIngredient(testIngredient1);
        burger.addIngredient(testIngredient2);

        burger.removeIngredient(1);

        assertEquals(2,burger.ingredients.size());
        assertEquals(testIngredient2,burger.ingredients.get(1));
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(testIngredient);
        burger.addIngredient(testIngredient1);

        burger.moveIngredient(0,1);

        assertEquals(testIngredient,burger.ingredients.get(1));
        assertEquals(testIngredient1,burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(testBun);
        burger.addIngredient(testIngredient);
        burger.addIngredient(testIngredient1);

        when(testBun.getPrice()).thenReturn(10F);
        when(testIngredient.getPrice()).thenReturn(1.5F);
        when(testIngredient1.getPrice()).thenReturn(0F);

        assertEquals(21.5F,burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(testBun);
        burger.addIngredient(testIngredient);
        burger.addIngredient(testIngredient1);

        when(testBun.getName()).thenReturn("testBun");
        when(testIngredient.getName()).thenReturn("testIngredient");
        when(testIngredient.getType()).thenReturn(SAUCE);
        when(testIngredient1.getName()).thenReturn("testIngredient1");
        when(testIngredient1.getType()).thenReturn(FILLING);
        when(burger.getPrice()).thenReturn(21.50F);

        assertEquals(
                "(==== testBun ====)\r\n" +
                        "= sauce testIngredient =\r\n" +
                        "= filling testIngredient1 =\r\n" +
                        "(==== testBun ====)\r\n" +
                        "\r\nPrice: 21,500000\r\n",
                burger.getReceipt()
        );
    }

}
