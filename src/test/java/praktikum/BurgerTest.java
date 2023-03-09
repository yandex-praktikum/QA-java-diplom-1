package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Before
    public void setUp(){
        burger = new Burger();
    }
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;
    @Test
    public void checkSetBuns(){
        burger.setBuns(bun);
        assertEquals ("Установлено не верное название и цена булочки",bun,burger.bun);
    }

    @Test
    public void checkAddIngredient(){
        burger.addIngredient(ingredient);
        assertEquals("Ингридиент не добавлен", 1,burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredient(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("Ингридиент не удалился",burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredient(){
        burger.addIngredient(new Ingredient(IngredientType.FILLING,"cutlet",100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE,"hot sauce",100));
        burger.moveIngredient(0,1);
        String expectedNameIngredient = "hot sauce";
        String actualNameIngredient = burger.ingredients.get(0).name;
        assertEquals("Неверное имя ингредиента",expectedNameIngredient,actualNameIngredient);
    }

    @Test
    public void checkBurgerGetPrice(){
        Mockito.when(ingredient.getPrice()).thenReturn(200.11F);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float actualPrice = burger.getPrice();
        float expectedPrice = 600.22F;
        assertEquals( expectedPrice, actualPrice,0);
    }

    @Test
    public void checkGetReceipt(){
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== red bun ====)\r\n= filling cutlet =\r\n(==== red bun ====)\r\n\r\nPrice: 700,000000\r\n";
        assertEquals(expectedReceipt,actualReceipt);
    }
}
