package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientClassGetTypeMethodTest {
    Ingredient ingredient;
    private static IngredientType type;
    private String VALID_NAME_OF_INGREDIENT = "ValidName";
    private Float VALID_PRICE = 100F;

    public IngredientClassGetTypeMethodTest(IngredientType type) {
        this.type = type;
    }
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getType() {
        return new Object[][] {
                { IngredientType.SAUCE},
                { IngredientType.FILLING},
        };
    }


    @Test
    public void getTypeSauseValidDataPositiveResult(){
        ingredient = new Ingredient(type, VALID_NAME_OF_INGREDIENT, VALID_PRICE);
        Assert.assertEquals("Метод getType класса Ingredient, возвращает не корректное значение", type, ingredient.getType());
    }


}
