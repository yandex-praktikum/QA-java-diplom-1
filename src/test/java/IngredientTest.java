import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest { //моки, стабы?
    Ingredient ingredient;
    private IngredientType type = IngredientType.valueOf("SAUCE");
    private String name = "Тар-Тар";
    private float price = 20.5f;
    @Before
    public void setUp(){
        ingredient = new Ingredient (type, name, price);
    }

    @Test
    public void getTypeTest(){
        Assert.assertEquals(type, ingredient.getType());
    }
    @Test
    public void getNameTest(){
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }



}
