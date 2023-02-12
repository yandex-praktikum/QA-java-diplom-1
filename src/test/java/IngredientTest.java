import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTestData() {
        return new Object[][]{
                {SAUCE, "ingredientName1", 0F},
                {FILLING, "ingredientName2", 12.12F},
        };
    }
    @Test
    public void getPriceReturnsTrueValue(){
        ingredient = new Ingredient(type, name, price);
        assertEquals(price,ingredient.getPrice(),0);
    }

    @Test
    public void getNameReturnsTrueValue(){
        ingredient = new Ingredient(type, name, price);
        assertEquals(name,ingredient.getName());
    }

    @Test
    public void getTypeReturnsTrueValue(){
        ingredient = new Ingredient(type, name, price);
        assertEquals(type,ingredient.getType());
    }
}
