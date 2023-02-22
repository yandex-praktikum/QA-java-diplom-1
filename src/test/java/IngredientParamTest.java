import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;


    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2} {3}") // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Космомясо", 100500F},
                {IngredientType.SAUCE, "Космобулка", 200500F},
                {IngredientType.FILLING, "Косморыбка", 300500F},
                {IngredientType.FILLING, "Космонечто", 400500F},
        };
    }

    @Test
    public void checkingTheMethodGetName() {
        ingredient = new Ingredient(type, name, price);

        String expectedResult = name;
        String actualResult = ingredient.getName();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkingTheMethodGetPrice() {
        ingredient = new Ingredient(type, name, price);

        float expectedResult = price;
        float actualResult = ingredient.getPrice();
        assertEquals(expectedResult, actualResult, 0.0F);
    }

    @Test
    public void checkingTheMethodGetType() {
        ingredient = new Ingredient(type, name, price);

        IngredientType expectedResult = type;
        IngredientType actualResult = ingredient.getType();
        assertEquals(expectedResult, actualResult);
    }
}
