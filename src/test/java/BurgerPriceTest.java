import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class BurgerPriceTest {
    private Burger burger;
    private Ingredient ingredientSouse;
    private Ingredient ingredientFilling;
    private final String name;
    private final float price;


    public BurgerPriceTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        burger = new Burger();
        ingredientSouse = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        ingredientFilling = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
    }

    @Parameterized.Parameters()
    public static Object[][] bunData() {
        return new Object[][] {
                {"empty", 0 },
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"glutenFreeBun", 1000}
        };
    }

    @Test
    public void getCorrectPrice() {
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSouse);
        float expected = bun.price * 2 + ingredientFilling.price + ingredientSouse.price;
        float actual = burger.getPrice();
        assertEquals("Некорректная цена бургера", expected, actual);
    }
}
