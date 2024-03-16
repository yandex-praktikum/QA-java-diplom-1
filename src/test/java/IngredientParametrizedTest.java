import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientParametrizedTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "ShellfishMeat", 1.80f},
                {IngredientType.SAUCE, "GalacticSauce", 1.50f},
                {IngredientType.SAUCE, "SpicyX", 1.90f}
        });
    }
    @Test
    public void testIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(),0.001f);

    }
}
