import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class IngredientTests {
    String ingredientName = "hot sauce";
    float ingredientPrice = 30.25f;

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,ingredientName,ingredientPrice);
        float actual = ingredient.getPrice();
        assertThat("Метод getPrice возвращает неверное значение поля price",actual,equalTo(ingredientPrice));
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,ingredientName,ingredientPrice);
        String actual = ingredient.getName();
        assertThat("Метод getName возвращает неверное значение поля Name",actual,equalTo(ingredientName));
    }

    @Test
    public void getIngredientType(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,ingredientName,ingredientPrice);
        IngredientType actual = ingredient.getType();
        assertThat("Метод getIngredientType вовзращает неверное значение поля type",actual,equalTo(IngredientType.FILLING));
    }

}
