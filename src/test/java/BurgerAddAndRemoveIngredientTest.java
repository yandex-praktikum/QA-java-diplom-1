import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerAddAndRemoveIngredientTest {
    Burger burger;
    Ingredient ingredient;

    @Parameterized.Parameter(0)
    public IngredientType type;

    @Parameterized.Parameter(1)
    public String name;

    @Parameterized.Parameter(2)
    public static float price = RandomUtils.nextFloat();
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Sauce", price},
                {IngredientType.FILLING, "Filling", price}
        });
    }

    @Before
    public void setUp() {
        //присвоили булочке название
        String name_burger = RandomStringUtils.randomAlphabetic(10);
        //создали булочку со случайным название и ценой
        Bun bun = new Bun(name_burger, price);
        burger = new Burger();
        burger.setBuns(bun);
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    @Description("Можно добавить ингредиент")
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    @Description("Можно удалить ингредиент")
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }
}