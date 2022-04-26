import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void checkCountOfIngredientTypesInList() {
        int expectedCountOfIngredientTypesInList = 2;
        int actualCountOfIngredientTypesInList = IngredientType.values().length;
        assertEquals(expectedCountOfIngredientTypesInList, actualCountOfIngredientTypesInList);
    }

}