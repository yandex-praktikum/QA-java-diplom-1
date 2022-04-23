import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void checkEnumSauce() {
        checkEnumElement("SAUCE",0);
    }

    @Test
    public void checkEnumFilling() {
        checkEnumElement("FILLING",1);
    }

    private void checkEnumElement(String expName, int expPos) {
        IngredientType iType = IngredientType.valueOf(expName);
        assertEquals("Нарушен порядок следования элементов", expPos, iType.ordinal());
    }
}
