package praktikum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger;

    @Before
    public void init(){

        burger = new Burger();

    }

    @Test
    public void testSetBuns (){
        burger.setBuns(bun);
        Assert.assertEquals("Variables are not equal", burger.bun, bun);

    }

    @Test
    public void testAddIngredient (){
        burger.addIngredient(ingredient);
        Assert.assertTrue("Object is not found", burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient () {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testMoveIngredient () {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Element is not equal", ingredient, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice(){
        Mockito.when(bun.getPrice()).thenReturn(50.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(25.0F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actualPrice = burger.getPrice();
        float expectedPrice = 125.0F;
        Assert.assertEquals("Price is incorrect", expectedPrice, actualPrice, 0);
    }

    @Test
    public void testGetReceipt () {

        Mockito.when(bun.getName()).thenReturn("Краторная булка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус традиционный галактический");

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();

        String expected = "(==== Краторная булка ====)\r\n" + "= sauce Соус традиционный галактический =\r\n" + "(==== Краторная булка ====)\r\n" + "\r\nPrice: 0,000000\r\n";
        Assert.assertEquals(expected, actual);

    }


}