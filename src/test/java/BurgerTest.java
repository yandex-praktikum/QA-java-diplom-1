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
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    protected final static String BUN_NAME = "black bun";
    protected final static String SOUSE_NAME = "sour cream";
    protected final static String CUTLET_NAME = "cutlet";
    protected final static String DINOSAUR_NAME = "dinosaur";
    protected final static float BUN_PRICE = 100.0f;
    protected final static float SOUSE_PRICE = 200.0f;
    protected final static float CUTLET_PRICE = 100.0f;
    protected final static float DINOSAUR_PRICE = 200.0f;
    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;

    @Before
    public void objectPrepare(){
        burger = new Burger();
   }

   @Test
   public void checkAddBunTest(){
       // Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        burger.setBuns(bun);
        assertEquals("Нужная булочка отсутствует в бургере!", bun, burger.bun);
   }

    @Test
    public void checkAddIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue("Нужный ингредиент отсутствует в бургере!", burger.ingredients.contains(ingredient));
    }

    @Test
    public void checkRemoveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("Ингредиент не удален из бургера!", burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиент не перемещен внутри бургера!", ingredient, burger.ingredients.get(1));
    }


    @Test
    public void checkBurgerPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(CUTLET_PRICE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertThat("Неверная стоимость ингредиента!", burger.getPrice(), is(300.0f));
    }

    @Test
    public void checkBurgerRecipientTest(){
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(CUTLET_PRICE);
        Mockito.when(ingredient.getName()).thenReturn(CUTLET_NAME);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getPrice()).thenReturn(DINOSAUR_PRICE);
        Mockito.when(ingredient2.getName()).thenReturn(DINOSAUR_NAME);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient3.getPrice()).thenReturn(SOUSE_PRICE);
        Mockito.when(ingredient3.getName()).thenReturn(SOUSE_NAME);
        Mockito.when(ingredient3.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce sour cream =\r\n" +
                "= filling cutlet =\r\n" +
                "= filling dinosaur =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 700,000000\r\n";
        System.out.println(burger.getReceipt());
        assertThat("Информация о бургере некорректна!", burger.getReceipt().equals(expectedReceipt));
    }

}
