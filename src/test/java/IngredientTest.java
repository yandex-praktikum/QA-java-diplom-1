import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    public IngredientType type = IngredientType.SAUCE;
    public String name = "Соус";
    public float price = 234.4f;
    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void getIngredientTest(){
        assertEquals(type, ingredient.getType());
    }

    @Test public void getNameTest(){
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest(){
        assertEquals(price, ingredient.getPrice(), 0);
    }
}