import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void IngridientEnumCointainsNotNullValues(){
        for (IngredientType type : IngredientType.values()) {
            Assert.assertNotNull(type);
        }
    }
}
