import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType typeField;
    private final String nameField;
    private final float priceField;


    public IngredientTest(IngredientType typeField, String nameField, float priceField){
        this.typeField = typeField;
        this.nameField = nameField;
        this.priceField = priceField;

    }

    @Parameterized.Parameters
    public static Object[][] testParams() {
        return new Object[][]{
                {SAUCE, "Соус Spicy-X", 90.9f},
                {SAUCE, "Соус с шипами Антарианского плоскоходца", 88.5f},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 1337.07f},
                {FILLING, "Хрустящие минеральные кольца", 300.01f},
        };
    }

    @Test
    public void newIngredientTypeCheckTest() {
        Ingredient ingredient = new Ingredient(typeField, nameField, priceField);
        assertEquals(typeField, ingredient.getType());
    }

    @Test
    public void newIngredientNameCheckTest() {
        Ingredient ingredient = new Ingredient(typeField, nameField, priceField);
        assertEquals(nameField, ingredient.getName());
    }

    @Test
    public void newIngredientPriceCheckTest() {
        Ingredient ingredient = new Ingredient(typeField, nameField, priceField);
        assertEquals(priceField, ingredient.getPrice(), 0);
    }


}
