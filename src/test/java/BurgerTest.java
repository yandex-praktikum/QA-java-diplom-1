import org.junit.Assert;
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

@RunWith(value = Parameterized.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    private String bunName;
    private float bunPrice;
    private IngredientType ingredientType, ingredientType2;
    private String ingredientName, ingredientName2;
    private float ingredientPrice, ingredientPrice2;
    private String bunLook;
    private String ingredientPrint, ingredientPrint2;
    private String totalPriceBun;
    private String totalPriceOfIngredient;
    private String totalPriceOfTwoIngredient;

    public BurgerTest(String bunName, float bunPrice,
                      IngredientType ingredientType, String ingredientName, float ingredientPrice,
                      IngredientType ingredientType2, String ingredientName2, float ingredientPrice2,
                      String bunLook, String ingredientPrint, String ingredientPrint2, String totalPriceBun,
                      String totalPriceOfIngredient, String totalPriceOfTwoIngredient) {

        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredientType2 = ingredientType2;
        this.ingredientName2 = ingredientName2;
        this.ingredientPrice2 = ingredientPrice2;
        this.bunLook = bunLook;
        this.ingredientPrint = ingredientPrint;
        this.ingredientPrint2 = ingredientPrint2;
        this.totalPriceBun = totalPriceBun;
        this.totalPriceOfIngredient = totalPriceOfIngredient;
        this.totalPriceOfTwoIngredient = totalPriceOfTwoIngredient;
    }


    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]
                {
                        {"black bun", 10.00f,
                                IngredientType.SAUCE,"hot sauce", 10.00f,
                                IngredientType.FILLING,"cutlet", 10.00f,
                                "(==== black bun ====)\r\n",
                                "= sauce hot sauce =\r\n",
                                "= filling cutlet =\r\n",
                                "Price: 20,000000\r\n",
                                "Price: 30,000000\r\n",
                                "Price: 40,000000\r\n"},

                        {"white bun", 20.00f,
                                IngredientType.FILLING, "cutlet", 20.00f,
                                IngredientType.SAUCE, "hot sauce", 20.00f,
                                "(==== white bun ====)\r\n",
                                "= filling cutlet =\r\n",
                                "= sauce hot sauce =\r\n",
                                "Price: 40,000000\r\n",
                                "Price: 60,000000\r\n",
                                "Price: 80,000000\r\n"},

                        {"red bun", 30.00f,
                                IngredientType.FILLING, "dinosaur", 30.00f,
                                IngredientType.SAUCE, "chili sauce", 30.00f,
                                "(==== red bun ====)\r\n",
                                "= filling dinosaur =\r\n",
                                "= sauce chili sauce =\r\n",
                                "Price: 60,000000\r\n",
                                "Price: 90,000000\r\n",
                                "Price: 120,000000\r\n"}
                };
    }

    @Before
    public void createBurger() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    // Проверка сборки бургера
    @Test
    public void bunBurgerTest() {
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(bun);
        String expected = bunLook + bunLook + "\r\n" + totalPriceBun;
        String actual = burger.getReceipt();
        Assert.assertEquals("Ошибка, это не булочка" + bunName, expected, actual);
    }

    // Проверка добавления ингредиента
    @Test
    public void addIngredientBurgerTest() {

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expected = bunLook + ingredientPrint + bunLook + "\r\n" + totalPriceOfIngredient;
        String actual = burger.getReceipt();
        Assert.assertEquals("Ошибка, это не бургер из " +
                bunName + " " + ingredientName + " " + bunName, expected, actual);
    }

    // Проверка метода удаления ингредиентов
    @Test
    public void removeIngredientTest() {
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        String expected = bunLook + bunLook + "\r\n" + totalPriceBun;
        System.out.println(expected);
        System.out.println(burger.getReceipt());
        String actual = burger.getReceipt();
        Assert.assertEquals("Ошибка, это не булочка " + bunName, expected, actual);
    }

    // Проверка метода перемещения ингридиентов
    @Test
    public void moveIngredientTest() {
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient2.getType()).thenReturn(ingredientType2);
        Mockito.when(ingredient2.getName()).thenReturn(ingredientName2);
        Mockito.when(ingredient2.getPrice()).thenReturn(ingredientPrice2);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        String expected = bunLook + ingredientPrint2 + ingredientPrint + bunLook + "\r\n" + totalPriceOfTwoIngredient;
        System.out.println(expected);
        System.out.println(burger.getReceipt());
        String actual = burger.getReceipt();
        Assert.assertEquals("Ошибка, это не бургер из " +
                bunName + " " + ingredientName2 + " " + ingredientName + " " + bunName, expected, actual);
    }
}
