import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void getReturnCorrectInformation() {
        IngredientType type= IngredientType.FILLING;
        String name= "cutlet";
        float price=100;
        Ingredient ingredient= new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(),0);
    }
    @Test
    public void getPriceReturnCorrect() {
        IngredientType type= IngredientType.SAUCE;
        String name= "sour cream";
        float price=200;
        Ingredient ingredient= new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(),0);
    }
}

