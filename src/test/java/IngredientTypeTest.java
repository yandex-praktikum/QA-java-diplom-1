import org.junit.Test;
import praktikum.IngredientType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    protected final static String INGREDIENT_TYPE_FILLING = "FILLING";
    protected final static String INGREDIENT_TYPE_SAUCE = "SAUCE";

    @Test
    public void checkEnumFillingName(){
        assertTrue("Неверное наименование типа ингредиента FILLING!", IngredientType.FILLING.name().equals(INGREDIENT_TYPE_FILLING));
    }


    @Test
    public void checkEnumSauceName(){
        assertTrue("Неверное наименование типа ингредиента SAUCE!", IngredientType.SAUCE.name().equals(INGREDIENT_TYPE_SAUCE));
    }

    @Test
    public void checkEnumSize(){
        assertThat("Массив IngredientType пустой!", IngredientType.values().length>0);
    }
}
