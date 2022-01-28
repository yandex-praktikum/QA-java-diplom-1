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

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final float BUN_PRICE = 2.5f;
    private final float INGREDIENT_PRICE = 2f;
    private final float BURGER_PRICE= 2*BUN_PRICE+INGREDIENT_PRICE;
    private final String BUN_NAME = "BUN";
    private final String INGREDIENT_NAME = "ING";
    private Burger burger;
@Mock
private Bun mBun;
@Mock
private Ingredient mIngredient;

@Before
public void before(){
    burger = new Burger();
    burger.setBuns(mBun);
    burger.addIngredient(mIngredient);
}
    @Test
    public void testGetPriceWorkingCorrect(){
    Mockito.when(mBun.getPrice()).thenReturn(BUN_PRICE);
    Mockito.when(mIngredient.getPrice()).thenReturn(INGREDIENT_PRICE);

    assertEquals("Проверка расчета цены бургера",
            BURGER_PRICE,
            burger.getPrice(),0);
    }
    @Test
    public void testGetReceiptReturnsNameOfTheBun(){
        Mockito.when(mBun.getName()).thenReturn(BUN_NAME);
        Mockito.when(mIngredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(mIngredient.getType()).thenReturn(IngredientType.FILLING);
        assertEquals("Имя булки есть в рецепте",true,burger.getReceipt().contains(BUN_NAME));
    }
    @Test
    public void testGetReceiptReturnsNameOfTheIngredient(){
        Mockito.when(mBun.getName()).thenReturn(BUN_NAME);
        Mockito.when(mIngredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(mIngredient.getType()).thenReturn(IngredientType.FILLING);
        assertEquals("Имя ингредиента есть в рецепте",true,burger.getReceipt().contains(INGREDIENT_NAME));
    }
    @Test
    public void testGetReceiptReturnsPrice(){
        Mockito.when(mBun.getName()).thenReturn(BUN_NAME);
        Mockito.when(mIngredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(mIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mIngredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(mBun.getPrice()).thenReturn(BUN_PRICE);
        assertEquals(true,burger.getReceipt().contains("Price:"));//вызываю метод

    }

}
