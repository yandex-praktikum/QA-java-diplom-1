package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    IngredientType type;
    String name;
    float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTest(){
        return new Object[][]{
                {SAUCE, "Железобетонный батон", 393F},
                {FILLING,"Железобетонный батон", 393F},
                {null,"Железобетонный батон", 393F}
        };
    }

    @Test
    public void checkIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(type, "Железобетонный батон", 393F);
        assertEquals(type, ingredient.getType());
    }
}