package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.is;

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

    @Parameterized.Parameters(name = "Перебор ингридиентов: {0} {1} {2}")
    public static Object[] getLionParameters() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус Spicy-X", 90.0E0f},
                {IngredientType.SAUCE,"Соус фирменный Space Sauce", 80.0E0f},
                {IngredientType.SAUCE, "Соус традиционный галактический", 15.0E0f},
                {IngredientType.SAUCE,"Соус с шипами Антарианского плоскоходца", 88.0E0f},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337.0E0f},
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000.0E0f},
                {IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424.0E0f},
                {IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988.0E0f},
                {IngredientType.FILLING, "Хрустящие минеральные кольца", 300.0E0f},
                {IngredientType.FILLING, "Плоды Фалленианского дерева", 874.0E0f},
                {IngredientType.FILLING, "Кристаллы марсианских альфа-сахаридов", 762.0E0f},
                {IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400.0E0f},
                {IngredientType.FILLING, "Сыр с астероидной плесенью", 4142.0E0f},
        };
    }

    @Test
    public void testGetPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);
        MatcherAssert.assertThat("Ты не обманешь меня жадный марсиашка =/", price, is (ingredient.getPrice()));
    }

    @Test
    public void testGetName(){
        Ingredient ingredient = new Ingredient(type, name, price);
        MatcherAssert.assertThat("Но я же показывал на другое...", name, is (ingredient.getName()));
    }

    @Test
    public void testGetType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        MatcherAssert.assertThat("Слишком непонятное меню +_+", type, is (ingredient.getType()));
    }

}