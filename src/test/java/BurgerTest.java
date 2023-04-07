import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger;

    //булочка
    public Bun getMockBun() {
        Bun bunMock =  mock(Bun.class);
        when(bunMock.getName()).thenReturn("white bun");
        when(bunMock.getPrice()).thenReturn(200F);
        return  bunMock;
    }

    //тип ингрдиента SAUCE
    public Ingredient getMockSauce() {
        Ingredient sauceMock = mock(Ingredient.class);
        when(sauceMock.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceMock.getName()).thenReturn("sour cream");
        when(sauceMock.getPrice()).thenReturn(200F);
        return sauceMock;
    }

    //тип ингрдиента FILLING
    public Ingredient getMockFilling() {
        Ingredient fillingMock = mock(Ingredient.class);
        when(fillingMock.getType()).thenReturn(IngredientType.FILLING);
        when(fillingMock.getName()).thenReturn("dinosaur");
        when(fillingMock.getPrice()).thenReturn(200F);
        return fillingMock;
    }

    @Before
    public void start() {
        burger = new Burger();
    }

    @Test
    public void checkBunTest() {
        Bun bunExpected = getMockBun();
        burger.setBuns(bunExpected);
        Assert.assertEquals(bunExpected,burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        Ingredient ingredientExpected = getMockSauce();
        burger.addIngredient(ingredientExpected);
        Assert.assertEquals(ingredientExpected,burger.ingredients.get(0));
    }

    @Test
    public void checkRemoveIngredientTest() {
        Ingredient ingredient = getMockFilling();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void checkMoveIngredientTest() {
        Ingredient sauce = getMockSauce();
        Ingredient filling = getMockFilling();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(sauce.name, burger.ingredients.get(1).name);
    }

    @Test
    public void checkGetPriceTest() {
        Bun bun = getMockBun();
        Ingredient sauce = getMockSauce();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        float actualPrice = burger.getPrice();
        Assert.assertEquals(600, actualPrice, 0);
    }

    @Test
    public void checkGetReceiptTest() {
        Bun bun = getMockBun();
        Ingredient sauce = getMockSauce();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        String actualResult = burger.getReceipt();
        String expectedResult = String.format("(==== white bun ====)%n" +
                "= sauce sour cream =%n" +
                "(==== white bun ====)%n" + "%nPrice: 600,000000%n");
        Assert.assertEquals(expectedResult, actualResult);
    }

}
