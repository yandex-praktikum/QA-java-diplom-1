import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private final String name = "Соус Spicy-X";
    private final float price = 90;

    @Mock
    IngredientType type;


    @Test
    public void checkIngredientPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Неверная стоимость ингредиента!", price, ingredient.getPrice(), 0);
    }

    @Test
    public void checkIngredientName(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Неправильное название ингредиента!", name, ingredient.getName());
    }

    @Test
    public void checkIngredientType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Неправильный тип ингредиента!", type, ingredient.getType());
    }
}
