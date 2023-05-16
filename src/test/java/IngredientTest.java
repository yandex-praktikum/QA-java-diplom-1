import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    @Mock
    Ingredient ingredient;
    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "test", 10);
    }
    @Test
    public void getPriceTest(){
        assertEquals("Цены должны совпадать",10, ingredient.getPrice(), 0);

    }
    @Test
    public void getNameTest() {
        assertEquals("Названия должны совпадать","test",ingredient.getName());
    }
    @Test
    public void getTypeTest() {
        assertEquals("Типы должны совпадать",IngredientType.SAUCE, ingredient.getType());
    }
}
