import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class NameSuccessTest {
    private Bun bun;
    private final String name;
    private float price;
    private IngredientType ingredientType;
    private  boolean testresult;
    private Ingredient ingredient;

    private static final String longString2043 = Utils.randomAlphabeticString(2043);

    public NameSuccessTest(String name) {
        this.name = name;

    }

@Parameterized.Parameters (name = "name = {0}")
    public static Object[][] getTestBunData(){
    return new Object[][] {
            {"Word "},
            {" Word"},
            {"Word word word"},
            {"Слово"},
            {"wordСловоCH4255öäβ▲♦♥~`!@#$%^&*()_+?:\"{}[];’"},
            {"2048="+longString2043},
    };
}

@Before
public void setUpBun(){
        price =  2.1f;
        testresult = true;
        ingredientType = IngredientType.FILLING;
        bun = new Bun(name, price);
        ingredient = new Ingredient(ingredientType,name,price);
}

@Test
public void testBunNameSuccess()  {
    assertEquals("bun.getName() doesn't work properly", testresult, name.equals(bun.getName()));
}

@Test
    public void testIngredientName(){
    assertEquals("ingredient.getName() doesn't work properly", testresult, name.equals(ingredient.getName()));
}

}
