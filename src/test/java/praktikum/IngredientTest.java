package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус Spicy-X", 90},
                {IngredientType.SAUCE, "Соус фирменный Space Sauce", 80},
                {IngredientType.SAUCE, "Соус традиционный галактический", 15},
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000},
                {IngredientType.FILLING, "Кристаллы марсианских альфа-сахаридов", 762},
                {IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400}
        };
    }

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals("Incorrect ingredient's price",price, actualPrice, 0);
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        assertEquals("НIncorrect ingredient's name", name, actualName);
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        assertEquals("Incorrect ingredient's type", type, actualType);
    }
}
