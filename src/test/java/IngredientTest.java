import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String name;
    private final float price;
    private final IngredientType type;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, float price, String name ) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][]{
                {IngredientType.FILLING,	100,	"Bun"},
                {IngredientType.FILLING,	0,	null},
                {IngredientType.FILLING,	50,	"Bun"},
                {IngredientType.FILLING,	0,	"Bun"},
                {null,	50,	null},
                {null,	100,	"Bun"},
                {null,	0,	"Bun"}
        };
    }

    @Before
    public void createIngredient(){
        ingredient = new Ingredient(type,name,price);
    }
    @Test
    public void getNameTest(){
        assertEquals(name,ingredient.getName());
    }
    @Test
    public void getPriceTest(){
        assertEquals(price,ingredient.getPrice(),0f);
    }
    @Test
    public void getTypeTest(){
        assertEquals(type,ingredient.getType());
    }

}
