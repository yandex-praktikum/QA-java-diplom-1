package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private final String name = "Колбаска";
    private final float price = 299.99f;

    @Mock
    IngredientType type;
    private Ingredient ingredient;


    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }


    @Test
    public void getPriceTest() {
        assertEquals("Цена не соответствует ожидаемой", price, ingredient.getPrice(), 0.001);
    }

    @Test
    public void getNameTest() {
        assertEquals("Имя не соответствует ожидаемому", name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Тип не соответствует ожидаемому", type, ingredient.getType());
    }
}