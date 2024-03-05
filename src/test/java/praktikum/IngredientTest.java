package praktikum;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    public IngredientType type;
    public String name;
    public float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getExpected(){
        return new Object[][]{
                {IngredientType.FILLING, "сыр", 5.00f},
                {IngredientType.SAUCE, "кетчуп", 0.50f}
        };
    }

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0.001);
    }
@Test
    public void getNameTest(){
    Ingredient ingredient = new Ingredient(type, name, price);
String expected = name;
String actual = ingredient.getName();
assertEquals(expected, actual);
}
@Test
    public void getTypeTest(){
    Ingredient ingredient = new Ingredient(type, name, price);
IngredientType expectde = type;
IngredientType actual = ingredient.getType();
assertEquals(expectde, actual);
}

}
