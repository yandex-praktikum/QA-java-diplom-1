import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedIngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public ParametrizedIngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        };
    }
    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type,name,price);
        String actualIngredientName = ingredient.getName();
        assertEquals(name, actualIngredientName);
        System.out.println ("Ingredient name is: " + ingredient.getName());
    }
    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type,name,price);
        Float actualIngredientPrice = ingredient.getPrice();
        assertEquals(price, (double) actualIngredientPrice,0);
        System.out.println ("Price of " +  ingredient.getName() + " is: " + ingredient.getPrice());
    }
    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type,name,price);
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(type, actualIngredientType);
        System.out.println ("Type of " + ingredient.getName() + " is: " + ingredient.getType());
    }
}
