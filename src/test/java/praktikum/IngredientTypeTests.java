package praktikum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTests {

    private IngredientType[] testIngredientType;

    @Before
    public void setup(){
        testIngredientType = IngredientType.values();
    }

    @Test
    public void testIngredientTypeFilled(){
        assertNotNull(testIngredientType);
        assertEquals(2, testIngredientType.length);
    }

    @Test
    public void testSAUCEExists(){
        assertEquals("SAUCE", testIngredientType[0].toString());
    }

    @Test
    public void testFILLINGExists(){
        assertEquals("FILLING", testIngredientType[1].toString());
    }


}
