import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestBurger {
    private String bunName;
    private float bunPrice;
    private IngredientType type;
    private String ingredientName;
    private float ingredientPrice;
    private String result;
    public TestBurger (String bunName, float bunPrice, IngredientType type, String ingredientName, float ingredientPrice, String result){
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.type = type;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.result = result;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Ржаная", 10f, IngredientType.SAUCE, "Сырный", 25f, "(==== Ржаная ====)\r\n= sauce Сырный =\r\n(==== Ржаная ====)\r\n\r\nPrice: 45,000000\r\n"},
                {"Белая", 17.36f, IngredientType.FILLING, "Лист салата", 2.5f, "(==== Белая ====)\r\n= filling Лист салата =\r\n(==== Белая ====)\r\n\r\nPrice: 37,220001\r\n"},
                {"С кунжутом", 34.2f, IngredientType.FILLING, "Говяжья катлета", 250f, "(==== С кунжутом ====)\r\n= filling Говяжья катлета =\r\n(==== С кунжутом ====)\r\n\r\nPrice: 318,399994\r\n"}

        };
    }
    @Test
    public void testReceipt() {
       Burger burger = new Burger();
       burger.setBuns(bun);
       burger.addIngredient(ingredient);
       burger.addIngredient(ingredient);
       burger.moveIngredient(1,0);
       burger.removeIngredient(1);
       Mockito.when(bun.getName()).thenReturn(bunName);
       Mockito.when(bun.getPrice()).thenReturn(bunPrice);
       Mockito.when(ingredient.getType()).thenReturn(type);
       Mockito.when(ingredient.getName()).thenReturn(ingredientName);
       Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        System.out.println(burger.getReceipt());
        System.out.println(result);
       assertEquals(result, burger.getReceipt());

    }
}
