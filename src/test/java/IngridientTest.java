import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngridientTest {
    @Test
    public void getNameReturnCorrectValue() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Агтрекот", 100);
        String expectedName= "Агтрекот";
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName,actualName);
    }
    @Test
    public void getPriceReturnCorrectValue() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Агтрекот", 100);
        float expectedPrice= 100;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice,actualPrice,0.001);
    }

}
