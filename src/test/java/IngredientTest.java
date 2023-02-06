import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;


import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    public IngredientType type;
    public String name;
    public float price;
    public Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100f},
                {FILLING, "cutlet", 100f}
        };
    }
    @Test
    public void testIngredient(){
        ingredient =  new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.00);
        assertEquals(name, ingredient.getName());
        assertEquals(type, ingredient.getType());
    }

}
