package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


public class IngredientTest {


    Ingredient ingredient;
    String name = "name";
    float price = 10;

    @Mock
    IngredientType ingredientType;

    @Before
    public void setUp() throws Exception {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getPriceCallMethodReturnPrice() {
        assertEquals("должна возвращаться цена ингридиента", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameCallMethodReturnName() {
        assertEquals("должно возвращаться наименование ингридиента", name, ingredient.getName());
    }

    @Test
    public void getTypeCallMethodReturnIngredientType() {
        assertEquals("должен возвращаться тип ингридиента", ingredientType, ingredient.getType());
    }

}
