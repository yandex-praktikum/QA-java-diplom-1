import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class IngredientNotParameterizedTest {

    @Test
    public void getPriceReturnPriceTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"blabla",111f);
        float actual = ingredient.getPrice();
        assertThat(actual,is(111f));
    }

    @Test
    public void getNameReturnNameTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"blabla",111f);
        String actual = ingredient.getName();
        assertThat(actual,is("blabla"));
    }

}
