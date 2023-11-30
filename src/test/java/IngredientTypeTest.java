import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void checkIngredientTypePositive(){
        IngredientType[] ingredientTypesArray = new IngredientType[]{IngredientType.SAUCE, IngredientType.FILLING};
        Assert.assertArrayEquals("Типы ингредиентов не соответствуют ожидаемым", ingredientTypesArray,
                IngredientType.values());
    }
}
