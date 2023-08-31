import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
    private String bunResult;
    private String ingredientResult;
    public TestBurger (String bunName, float bunPrice, IngredientType type, String ingredientName, float ingredientPrice, String result, String bunResult, String ingredientResult){
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.type = type;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.result = result;
        this.bunResult = bunResult;
        this.ingredientResult = ingredientResult;

    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }
    @Mock
    Bun bun;
    Burger burger;
    @Mock
    Ingredient ingredient;
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Ржаная", 10f, IngredientType.SAUCE, "Сырный", 25f,
                        "(==== Ржаная ====)\r\n= sauce Сырный =\r\n(==== Ржаная ====)\r\n\r\nPrice: 45,000000\r\n",
                        "(==== Ржаная ====)\r\n(==== Ржаная ====)\r\n\r\nPrice: 20,000000\r\n",
                        "(==== Ржаная ====)\r\n= sauce Сырный =\r\n= sauce Сырный =\r\n(==== Ржаная ====)\r\n\r\nPrice: 70,000000\r\n"},
                {"Белая", 17.36f, IngredientType.FILLING, "Лист салата", 2.5f,
                        "(==== Белая ====)\r\n= filling Лист салата =\r\n(==== Белая ====)\r\n\r\nPrice: 37,220001\r\n",
                        "(==== Белая ====)\r\n(==== Белая ====)\r\n\r\nPrice: 34,720001\r\n",
                        "(==== Белая ====)\r\n= filling Лист салата =\r\n= filling Лист салата =\r\n(==== Белая ====)\r\n\r\nPrice: 39,720001\r\n"},
                {"С кунжутом", 34.2f, IngredientType.FILLING, "Говяжья катлета", 250f,
                        "(==== С кунжутом ====)\r\n= filling Говяжья катлета =\r\n(==== С кунжутом ====)\r\n\r\nPrice: 318,399994\r\n",
                        "(==== С кунжутом ====)\r\n(==== С кунжутом ====)\r\n\r\nPrice: 68,400002\r\n",
                        "(==== С кунжутом ====)\r\n= filling Говяжья катлета =\r\n= filling Говяжья катлета =\r\n(==== С кунжутом ====)\r\n\r\nPrice: 568,400024\r\n"}

        };
    }
    @Test
    public void setBuns(){
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        assertEquals(bunResult, burger.getReceipt());
    }
    @Test
    public void setIngredient(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        assertEquals(ingredientResult, burger.getReceipt());
    }
    @Test
    public void setRemoveIngredient(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(1,0);
        burger.removeIngredient(1);
        burger.removeIngredient(0);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        assertEquals(bunResult, burger.getReceipt());
    }
    @Test
    public void testReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        assertEquals(result, burger.getReceipt());

    }
}
