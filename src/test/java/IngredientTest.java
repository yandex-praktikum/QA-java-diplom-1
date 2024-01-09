import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientVariants() {
        return new Object[][] {
                {IngredientType.SAUCE, Utils.INGREDIENT_ONE, 15},
                {IngredientType.FILLING, Utils.INGREDIENT_TWO, 25},
                {null, Utils.INGREDIENT_ONE, 15},
                {IngredientType.FILLING, null, 25},
        };
    }
    @Before
    public void setUp() {
        try {
            ingredient = new Ingredient(type,name,price);
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

    }
    @Test
    public void testGetTypeReturnParameterValue (){
        assertEquals("Ожидалось что тип ингридиента будет "+type,type, ingredient.getType());
    }
    @Test
    public void testGetNameReturnParameterValue (){
        assertEquals("Ожидалось что имя ингридиента будет "+name,name, ingredient.getName());
    }
    @Test
    public void testGetPriceReturnParameterValue (){
        assertEquals("Ожидалось что цена ингридиента будет "+price,price, ingredient.getPrice(), 0f);
    }
}