import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerTest {
    private Burger burger;
    private Bun bunMock;
    private Ingredient ingredientMock;

    @Parameterized.Parameter
    public String ingredientName;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Сыр"},
                {"Кетчуп"},
                {"Салат"}
        });
    }

    @Before
    public void init() {
        bunMock = Mockito.mock(Bun.class);
        when(bunMock.getName()).thenReturn("Флюоресцентная булка R2-D3");
        when(bunMock.getPrice()).thenReturn(988.0f);

        ingredientMock = Mockito.mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock.getName()).thenReturn("Соус Spicy-X");
        when(ingredientMock.getPrice()).thenReturn(90.0f);

        burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
    }

    @Test
    public void addIngredientTest(){
        Ingredient ingredientMockFilling = Mockito.mock(Ingredient.class);
        when(ingredientMockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMockFilling.getName()).thenReturn(ingredientName);
        when(ingredientMockFilling.getPrice()).thenReturn(1.0f);

        burger.addIngredient(ingredientMockFilling);
        Assert.assertTrue(burger.ingredients.contains(ingredientMockFilling));
    }

    @Test
    public void removeIngredientTest(){
        int sizeOfListBurgerIngredients = burger.ingredients.size();
        burger.removeIngredient(0);
        int sizeOfListBurgerIngredientsAfterRemove = burger.ingredients.size();
        Assert.assertEquals(sizeOfListBurgerIngredients-1, sizeOfListBurgerIngredientsAfterRemove);
    }

    @Test
    public void moveIngredientTest(){
        Ingredient ingredientMockFilling = Mockito.mock(Ingredient.class);
        when(ingredientMockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMockFilling.getName()).thenReturn(ingredientName);
        when(ingredientMockFilling.getPrice()).thenReturn(1.0f);
        burger.addIngredient(ingredientMockFilling);
        int index = burger.ingredients.indexOf(ingredientMockFilling);
        int indexNew = 0;

        burger.moveIngredient(index, indexNew);
        Assert.assertEquals(0, burger.ingredients.indexOf(ingredientMockFilling));
    }

    @Test
    public void getPriceTest(){
        float bunPrice = 988.0f;
        float saucePrice = 90.0f;
        float expectedPrice = bunPrice * 2 + saucePrice;
       Assert.assertEquals(expectedPrice, burger.getPrice(), 0.01f);
    }

    @Test
    public void getReceiptTest() {
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                "= %s %s =%n" +
                "(==== %s ====)%n" +
                "%nPrice: %f%n", bunMock.getName(),
                ingredientMock.getType().toString().toLowerCase(), ingredientMock.getName(),
                bunMock.getName(), burger.getPrice());
        System.out.println(expectedReceipt);
        System.out.println(actualReceipt);
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}
