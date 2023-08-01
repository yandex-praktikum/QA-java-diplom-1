package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private Float price;

    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, Float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] getParams(){
        return new Object[][] {
                {IngredientType.SAUCE, "Соус", 12.4f},
                {IngredientType.SAUCE, "", 12.4f},
                {IngredientType.SAUCE, "", 0f},
                {IngredientType.FILLING, "Начинка", 24.4f},
                {IngredientType.FILLING, "", 12.4f},
                {IngredientType.FILLING, "", 0f},
        };
    }

    @Test
    public void ingredientCorrectNameReturns(){
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void ingredientCorrectTypeReturns(){
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void ingredientCorrectPriceReturns(){
        assertEquals(price, ingredient.getPrice());
    }

}
