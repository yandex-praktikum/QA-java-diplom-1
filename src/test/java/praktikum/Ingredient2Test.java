package praktikum;


import org.junit.Assert;
import org.junit.Test;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;


public class Ingredient2Test {

     @Test
    public void getPriceIsTrue() {

         float expected = 150;
         Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Сырный",expected);

         float actual = ingredient.getPrice();
         Assert.assertEquals(expected,actual,0.00f);
     }
    @Test
    public void getNameIsTrue() {

        String expected = "Сырный";
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,expected,150);

        String actual = ingredient.getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getTypeFillingIsTrue() {

        IngredientType expected = IngredientType.FILLING;
        String name = RandomStringUtils.randomAlphabetic(15);
        float price = Float.parseFloat(RandomStringUtils.randomNumeric(3));

        Ingredient ingredient = new Ingredient(expected,name,price);

        IngredientType actual = ingredient.getType();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getTypeSauceIsTrue() {

        IngredientType expected = IngredientType.SAUCE;
        String name = RandomStringUtils.randomAlphabetic(15);
        float price = Float.parseFloat(RandomStringUtils.randomNumeric(3));

        Ingredient ingredient = new Ingredient(expected,name,price);

        IngredientType actual = ingredient.getType();
        Assert.assertEquals(expected,actual);
    }
}
