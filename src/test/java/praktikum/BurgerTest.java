package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    List<Ingredient> ingredients = new ArrayList<>();
    IngredientType sauceType = IngredientType.SAUCE;
    IngredientType fillingType = IngredientType.FILLING;



      @Test
    public void checkSetBun(){
          Burger burger =  new Burger();
          Bun bun = new Bun ("test bun", 123);
          burger.setBuns(bun);
          assertEquals(bun, burger.bun);
          assertEquals("test bun", burger.bun.name);
          assertEquals(123, burger.bun.price, 0.0);
    }

    public void addIngredient(Burger burger){
        Ingredient hotSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 200);
        burger.addIngredient(hotSauce);
        Ingredient chickenFillet = new Ingredient(IngredientType.FILLING, "chicken fillet", 100);
        burger.addIngredient(chickenFillet);
    }
    public void setTestBun(Burger burger){
          Bun testBun = new Bun("test bun", 200);
          burger.setBuns(testBun);
    }
    @Test
    public void testAddIngredient(){
        Burger burger =  new Burger();
        addIngredient(burger);
        assertEquals(sauceType, burger.ingredients.get(0).type);
        assertEquals("hot sauce", burger.ingredients.get(0).name);
        assertEquals(200,burger.ingredients.get(0).price, 0.0);
        assertEquals(fillingType, burger.ingredients.get(1).type);
        assertEquals("chicken fillet", burger.ingredients.get(1).name);
        assertEquals(100, burger.ingredients.get(1).price, 0.0);
    }

    @Test
    public void testRemoveIngredient(){
        Burger burger =  new Burger();
        addIngredient(burger);
        burger.removeIngredient(0);

        assertEquals(fillingType, burger.ingredients.get(0).type);
        assertEquals("chicken fillet", burger.ingredients.get(0).name);
        assertEquals(100, burger.ingredients.get(0).price, 0.0);

        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());

    }
    @Test
    public void testMoveIngredient(){
          Burger burger = new Burger();
          addIngredient(burger);
          Ingredient dinoFillet = new Ingredient(IngredientType.FILLING, "dino fillet", 400);
          burger.addIngredient(dinoFillet);

        assertEquals(fillingType, burger.ingredients.get(2).type);
        assertEquals("dino fillet", burger.ingredients.get(2).name);
        assertEquals(400, burger.ingredients.get(2).price, 0.0);

        burger.moveIngredient(0,2);

        assertEquals(fillingType, burger.ingredients.get(0).type);
        assertEquals("chicken fillet", burger.ingredients.get(0).name);
        assertEquals(100, burger.ingredients.get(0).price, 0.0);

        assertEquals(fillingType, burger.ingredients.get(1).type);
        assertEquals("dino fillet", burger.ingredients.get(1).name);
        assertEquals(400, burger.ingredients.get(1).price, 0.0);

        assertEquals(sauceType, burger.ingredients.get(2).type);
        assertEquals("hot sauce", burger.ingredients.get(2).name);
        assertEquals(200,burger.ingredients.get(2).price, 0.0);

        burger.moveIngredient(1,2);

        assertEquals(fillingType, burger.ingredients.get(0).type);
        assertEquals("chicken fillet", burger.ingredients.get(0).name);
        assertEquals(100, burger.ingredients.get(0).price, 0.0);

        assertEquals(sauceType, burger.ingredients.get(1).type);
        assertEquals("hot sauce", burger.ingredients.get(1).name);
        assertEquals(200,burger.ingredients.get(1).price, 0.0);

        assertEquals(fillingType, burger.ingredients.get(2).type);
        assertEquals("dino fillet", burger.ingredients.get(2).name);
        assertEquals(400, burger.ingredients.get(2).price, 0.0);


    }

    @Test
    public void testGetReceiptOnlyBun(){
          Burger testBurger = new Burger();
          setTestBun(testBurger);
          String testReceipt = testBurger.getReceipt();
          System.out.println(testReceipt);
          String expectedReceipt = "(==== test bun ====)\r\n" +
                  "(==== test bun ====)\r\n" +
                  "\r\n" +
                  "Price: 400,000000\r\n";
          assertEquals(expectedReceipt, testReceipt);
    }

    @Test
    public void testGetReceipt(){
        Burger testBurger = new Burger();
        setTestBun(testBurger);
        addIngredient(testBurger);
        String testReceipt = testBurger.getReceipt();
        System.out.println(testReceipt);
        String expectedReceipt = "(==== test bun ====)\r\n" +
                "= sauce hot sauce =\r\n" +
                "= filling chicken fillet =\r\n" +
                "(==== test bun ====)\r\n" +
                "\r\n" +
                "Price: 700,000000\r\n";
        assertEquals(expectedReceipt, testReceipt);
    }
    @Mock
    Bun mockedBun;
    @Mock
    Ingredient mockedIngredient1;
    @Mock
    Ingredient mockedIngredient2;



    @Test
    public void testGetPrice(){
          List<Ingredient> mockedIngredients = new ArrayList<>();
          Burger mockedBurger = new Burger();
          mockedBurger.addIngredient(mockedIngredient1);
          mockedBurger.addIngredient(mockedIngredient2);
          mockedBurger.setBuns(mockedBun);
          Mockito.when(mockedBun.getPrice()).thenReturn(200.0F);
          Mockito.when(mockedBurger.ingredients.get(0).getPrice()).thenReturn(100.0F);
          Mockito.when(mockedBurger.ingredients.get(1).getPrice()).thenReturn(150.0F);
          float expectedPrice = 650;
          assertEquals(expectedPrice, mockedBurger.getPrice(), 0.0);


    }

    @Test
    public void testGetPriceOnlyBun(){
        List<Ingredient> mockedIngredients = new ArrayList<>();
        Burger mockedBurger = new Burger();
        mockedBurger.setBuns(mockedBun);
        Mockito.when(mockedBun.getPrice()).thenReturn(200.0F);
        float expectedPrice = 400;
        assertEquals(expectedPrice, mockedBurger.getPrice(), 0.0);


    }

}
