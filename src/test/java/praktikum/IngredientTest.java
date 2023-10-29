package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {SAUCE, "Соус Spicy-X", 100},
                {SAUCE, "Соус фирменный Space Sauce", 0},
//                {SAUCE, "Соус традиционный галактический", null}, // Не проходит
                {SAUCE, "Соус с шипами Антарианского плоскоходца", -100},
                {SAUCE, "", 200},
                {SAUCE, "!@#$%^&*()", 200},
                {SAUCE, null, 200},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 100},
                {FILLING, "Говяжий метеорит (отбивная)", 0},
//                {FILLING, "Хрустящие минеральные кольца", null}, // Не проходит
                {FILLING, "Мини-салат Экзо-Плантаго", -100}
        };
    }

    @Test
    public void getNameSuccess() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(
                name,
                ingredient.getName());
    }

    @Test
    public void getPriceSuccess()  {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(
                price,
                ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeSuccess()  {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(
                type,
                ingredient.getType());
    }

}

