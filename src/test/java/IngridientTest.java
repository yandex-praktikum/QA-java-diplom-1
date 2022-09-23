import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

// Some change to trigger pull request

@RunWith(Parameterized.class)
public class IngridientTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngridientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        };
    }

    @Test
    public void IngridientTypeTest(){
        Ingredient ingridirnt = new Ingredient(type, name, price);

        Assert.assertSame("Ingridient Type should be '" + type + "'", type, ingridirnt.getType() );
    }

    @Test
    public void ingridientNameTest(){
        Ingredient ingridirnt = new Ingredient(type, name, price);

        Assert.assertEquals("Ingridient Name should be '" + name + "'", name, ingridirnt.getName());
    }
    @Test
    public void ingridientPriceTest(){
        Ingredient ingridirnt = new Ingredient(type, name, price);

        Assert.assertEquals("Ingridient Price should be '" + price + "'", price, ingridirnt.getPrice(), 0.001);
    }
}
