import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

    final Float BUN_PRISE = 11.1f;
    final String BUN_NAME = "Name";
    final Float INGREDIENT_PRISE = 5.5f;
    final String INGREDIENT_NAME = "cheese";
    final IngredientType INGREDIENT_TYPE = IngredientType.SAUCE;
    private Burger burger;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Mock
    Ingredient ingredientFirst;

    @Mock
    Ingredient ingredientSecond;

    @Mock
    Bun bun;

    @Test
    public void setBunsBurger(){
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientBurger(){
        burger.addIngredient(ingredientFirst);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientBurger(){
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.removeIngredient(0);
        assertEquals( 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientBurger(){
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(1, 0);
        assertEquals(ingredientFirst, burger.ingredients.get(1));
        assertEquals(ingredientSecond, burger.ingredients.get(0));
    }

    @Test
    public void getPriceBurger(){
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        Mockito.when(burger.bun.getPrice()).thenReturn(BUN_PRISE);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(INGREDIENT_PRISE);
        Float actualGetPriceBurger = burger.getPrice();
        assertEquals((Float)27.7f, actualGetPriceBurger);
    }

    @Test
    public void getReceiptBurger(){
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);

        Mockito.when(burger.bun.getPrice()).thenReturn(BUN_PRISE);
        Mockito.when(burger.bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(INGREDIENT_PRISE);
        Mockito.when(ingredientFirst.getType()).thenReturn(INGREDIENT_TYPE);
        Mockito.when(ingredientFirst.getName()).thenReturn(INGREDIENT_NAME);

        String resultGetReceipt = burger.getReceipt();

        boolean checkNameBun = resultGetReceipt.contains(BUN_NAME);
        boolean checkPriseBurger = resultGetReceipt.contains("27,700001");
        boolean checkIngredientType = resultGetReceipt.contains(INGREDIENT_TYPE.toString().toLowerCase());
        boolean checkIngredientName = resultGetReceipt.contains(INGREDIENT_NAME);

        assertEquals(true, checkNameBun);
        assertEquals(true, checkPriseBurger);
        assertEquals(true, checkIngredientType);
        assertEquals(true, checkIngredientName);
    }
}
