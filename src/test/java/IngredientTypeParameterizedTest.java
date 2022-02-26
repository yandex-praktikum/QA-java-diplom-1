import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {

    private IngredientType type;
    private String name;
    private float price;

    public IngredientTypeParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.SAUCE,"name1",99f},
                {IngredientType.FILLING,"name2",99f}
        };
    }

    @Test
    public void getIngredientTypeReturnIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
        IngredientType actual = ingredient.getType();
        assertEquals(type,actual);
    }
}
