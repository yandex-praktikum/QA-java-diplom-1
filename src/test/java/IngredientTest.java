import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void checkGetPriceReturnsCorrectSaucePrice(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88);
        float expectedPrice = 88;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkGetPriceReturnsCorrectFillingPrice(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424);
        float expectedPrice = 424;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkGetNameReturnsCorrectSauceName(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        String expectedName = "Соус Spicy-X";
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void checkGetNameReturnsCorrectFillingName(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988);
        String expectedName = "Филе Люминесцентного тетраодонтимформа";
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void checkGetTypeReturnsCorrectType(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Плоды Фалленианского дерева", 70);
        IngredientType expectedType = IngredientType.FILLING;
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(expectedType, actualType);
    }
}