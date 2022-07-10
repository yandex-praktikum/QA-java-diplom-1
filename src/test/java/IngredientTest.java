import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void getPriceReturnsIngrediendtPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100.01f);
        float actual = ingredient.getPrice();
        Assert.assertEquals("Не отображается корректная цена ингредиента", 100.01f, actual, 0);
    }

    @Test
    public void getNameReturnsIngredientName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100.01f);
        String actual = ingredient.getName();
        Assert.assertEquals("Не отображается корректное имя ингредиента", "hot sauce", actual);
    }

    @Test
    public void getTypeReturnsIngredientType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100.01f);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("Не отображается корректный тип ингредиента", IngredientType.SAUCE, actual);
    }
}