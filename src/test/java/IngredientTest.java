import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;
public class IngredientTest {

    @Test
    public void getPriceTest() {
        //Arrange
        Ingredient ingredient = new Ingredient(SAUCE,"Бигмак", 100f);
        float expected = ingredient.price;

        //Act
        float actual = ingredient.getPrice();

        //Assert
        Assert.assertEquals("Цена не соответствует", expected, actual, 0f);
    }

    @Test
    public void getNameTest() {
        //Arrange
        Ingredient ingredient = new Ingredient(SAUCE,"Бигмак", 100f);
        String expected = ingredient.name;

        //Act
        String actual = ingredient.getName();

        //Assert
        Assert.assertEquals("Имя не соответствует", expected, actual);
    }

    @Test
    public void getTypeTest() {
        //Arrange
        Ingredient ingredient = new Ingredient(SAUCE,"Бигмак", 100f);

        //Act
        IngredientType actual = ingredient.getType();

        //Assert
        Assert.assertEquals("Тип ингредиента не соответствует", SAUCE, actual);
    }
}
