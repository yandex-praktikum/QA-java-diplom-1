import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;

public class IngredientTest {

    @Test
    public void checkCanGetPrice(){
        float price = 150.00F;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "mayo", price);
        float actual = ingredient.getPrice();
       assertEquals(price, actual);
    }

    @Test
    public void checkCanGetName() {
        String name = "blue cheese";
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, 100.00F);
        String actual = ingredient.getName();
        assertEquals(name, actual);
    }

    @Test
    public void checkCanGetType(){
        IngredientType type = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(type, "chicken",200.00F);
        IngredientType actual = ingredient.getType();
        assertEquals(type, actual);
    }

}
