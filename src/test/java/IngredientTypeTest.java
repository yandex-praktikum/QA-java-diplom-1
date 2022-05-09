import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType expectedType;
    private final IngredientType actualType;


    public IngredientTypeTest(IngredientType expectedType, IngredientType actualType) {
        this.expectedType = expectedType;
        this.actualType = actualType;
    }

    @Parameterized.Parameters(name = "Передаем: {0}, Получаем: {1}")
    public static Object[][] ingredientTypes() {
        List<Ingredient> ingredientList = List.of(new Ingredient(SAUCE, "tomatoes", 100F)
                , new Ingredient(FILLING, "chicken", 200F));
        return new Object[][]{
                {ingredientList.get(0).getType(), IngredientType.SAUCE},
                {ingredientList.get(1).getType(), IngredientType.FILLING}
        };
    }

    @Test
    public void typeTest(){
        Assert.assertEquals(expectedType, actualType);
    }
}
