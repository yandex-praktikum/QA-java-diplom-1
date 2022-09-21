import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedIngredientGetNameTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public ParameterizedIngredientGetNameTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 0},
                {IngredientType.SAUCE, "HOT SAUCE", 0},
                {IngredientType.SAUCE, "горячий соус", 0},
                {IngredientType.SAUCE, "ГОРЯЧИЙ СОУС", 0},
                {IngredientType.SAUCE, "12345 67890", 0},
                {IngredientType.SAUCE, "Qas10!@#$%^&*()/*-+Абв", 0},
                {IngredientType.SAUCE, null, 0},
                {IngredientType.SAUCE, "", 0},
                {IngredientType.SAUCE, " ", 0},
                {IngredientType.SAUCE,  "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a,", 0},
        };
    }

    @Test
    public void getNameReturnsName() {
        Ingredient ingredient = new Ingredient(type, name, price);

        String actual = ingredient.getName();

        assertEquals("Returns incorrect name", name, actual);
    }
}
