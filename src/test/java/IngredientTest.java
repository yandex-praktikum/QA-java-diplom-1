import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Mock
    private IngredientType type;

    private Ingredient ingredient;


    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);
        ingredient = new Ingredient(type,"Помидорка", 15.5f);
    }


    @Test
    public void getPriceTest(){
        assertEquals("Стоимость ингридиента не 15.5!",15.5f,ingredient.getPrice(), Constant.DELTA);
    }

    @Test
    public void getNameTest(){
        assertEquals("Имя ингридиента не Помидорка!","Помидорка",ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        assertEquals("Тип отданного параметра не соответствует классу IngredientType",type, ingredient.getType());
    }

}
