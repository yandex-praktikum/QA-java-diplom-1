package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.EnumSet;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest{

    IngredientType type;

    public IngredientTypeTest(IngredientType type){
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][] {
                {IngredientType.FILLING},
                {IngredientType.SAUCE},
        };
    }

    @Test
    public void ingredientTypesTest(){
        assertTrue(EnumSet.allOf(IngredientType.class).contains(type));
    }
}