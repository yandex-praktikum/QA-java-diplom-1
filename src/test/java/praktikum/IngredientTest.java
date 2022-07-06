package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    //Передоваемое тестовое имя и цена
    private final String EXPECTED_NAME = "test sauce";
    private final float EXPECTED_PRICE = 7.77F;
    private Ingredient ingredient;

    @Mock
    private IngredientType type;

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, EXPECTED_NAME, EXPECTED_PRICE);
    }

    //Проверяем, что метод getType возвращает тип (объект) указанный в конструкторе
    @Test
    public void getTypeOfIngredient() {
        assertEquals("The type of the ingredient does not match the specified!", ingredient.getType(), type);
    }

    //Проверяем, что метод getName возвращает имя указанное в конструкторе
    @Test
    public void getNameOfIngredient() {
        String actual = ingredient.getName();
        assertEquals("The name of the ingredient does not match the specified!", actual, EXPECTED_NAME);
    }

    //Проверяем, что метод getPrice возвращает цену указанную в конструкторе
    @Test
    public void getPriceOfIngredient() {
        float actual = ingredient.getPrice();
        assertEquals("The price of the ingredient does not match the specified!", actual, EXPECTED_PRICE, 0);
    }

}