
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {


    @Test
    public void getIngredientTypeEnumSauce(){
       IngredientType type = IngredientType.SAUCE;
        assertEquals("Должен вернуться тип SAUCE", "SAUCE", type.name());
    }

    @Test
    public void getIngredientTypeEnumFilling(){
        IngredientType type = IngredientType.FILLING;
        assertEquals("Должен вернуться тип FILLING", "FILLING", type.name());
    }
}
