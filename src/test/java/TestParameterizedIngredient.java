import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestParameterizedIngredient {

    private final String name;
    private final Float prise;
    private  IngredientType type;

    public TestParameterizedIngredient(String name, Float prise, IngredientType type){
        this.name = name;
        this.prise = prise;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][]getIngredientsType(){
        return new Object[][]{
                {"Test", 5.5f, IngredientType.SAUCE},
                {"Test", 5.5f, IngredientType.FILLING},
                {"Test", 5.5f, null},
        };
    }

    @Test
    public void getTypeIngredient() {
        Ingredient ingredient = new Ingredient(type, name, prise);
        IngredientType resultGetType = ingredient.getType();
        assertEquals("Ingredient Type is"+type, type, resultGetType);
    }
}
