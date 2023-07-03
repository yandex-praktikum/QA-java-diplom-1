import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void init(){
        ingredient = new Ingredient( SAUCE, "сальса", 100);
    }

    @Test
    public void getNameTest(){
        assertEquals("сальса", ingredient.getName());
    }

    @Test
    public void getPriceTest(){
        assertEquals(100, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeTest(){
        assertEquals(SAUCE, ingredient.getType());
    }
}
