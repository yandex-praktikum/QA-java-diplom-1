import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(Parameterized.class)
public class BurgerParameterTest {

    private final Bun bun;
    private final List<Ingredient> ingredients;
    private float priceResult;
    private final Burger burger = new Burger();

    public BurgerParameterTest(Bun bun, List<Ingredient> ingredients, float priceResult){
        this.bun = bun;
        this.ingredients = ingredients;
        this.priceResult = priceResult;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getTestData() {
        return new Object[][] {
                { new Bun("Test1", 20),
                        Stream.of(new Ingredient(IngredientType.SAUCE, "Ing1", 20))
                                .collect(Collectors.toList()), 60},
                { new Bun("Test2", 30),
                        Stream.of(new Ingredient(IngredientType.SAUCE, "Ing1", 20),
                                  new Ingredient(IngredientType.FILLING, "Ing2", 30))
                                .collect(Collectors.toList()), 110},
        };
    }

    @Test
    public void getPriceCalculateCorrectPrice(){
        burger.setBuns(bun);
        burger.ingredients = ingredients;
        Assert.assertEquals(priceResult, burger.getPrice(), 0);
    }
}
