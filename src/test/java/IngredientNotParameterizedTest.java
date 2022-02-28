import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IngredientNotParameterizedTest {

    @Test
    public void getPriceReturnPriceTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"blabla",111f);
        float actual = ingredient.getPrice();
        assertThat("Метод вернул неверное значение цены.",actual,is(111f));
    }

    @Test
    public void getNameReturnNameTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"blabla",111f);
        String actual = ingredient.getName();
        assertThat("Метод вернул неверное значение названия.",actual,is("blabla"));
    }

}
