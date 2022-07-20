package praktikum;
import org.junit.Assert;
import org.junit.Test;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;




public class IngredientTest {

    //Проверяем метод, получения цены ингридиента
    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(SAUCE,"hot sauce",100);
        Assert.assertEquals(100, ingredient.getPrice(), 0.0f);
    }
    //Проверяем метод получения названия ингридиента
    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(SAUCE,"sour cream",200);
        Assert.assertEquals("sour cream", ingredient.getName());
    }
    //Проверяем метод получения типа ингридиента
    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(FILLING,"cutlet",100);
        Assert.assertEquals(FILLING, ingredient.getType());
    }







}
