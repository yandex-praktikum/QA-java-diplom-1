package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {

    Burger burger = new Burger();

    private final IngredientType ingredientType;
    private final String expected;

    public BurgerParametrizedTest(String ingredientName, IngredientType ingredientType){
        this.ingredientType = ingredientType;
        expected = "(==== Тестовая булочка ====)\r\n" +
                "= " + ingredientName + " Тестовый ингридиент =\r\n" +
                "(==== Тестовая булочка ====)\r\n" +
                "\r\nPrice: 0,000000\r\n";
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"sauce", IngredientType.SAUCE},
                {"filling", IngredientType.FILLING}
        };
    }

    @Test
    public void getRecipientTest(){
        Ingredient ingredient = new Ingredient(ingredientType, "Тестовый ингридиент", 0);
        Bun bun = Mockito.mock(Bun.class);

        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Тестовая булочка");

        String actual = burger.getReceipt();
        assertEquals("Полученая строка не соответствует ожидаемой", expected, actual);
    }
}
