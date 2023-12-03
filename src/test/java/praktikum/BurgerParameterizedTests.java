package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(Parameterized.class)
public class BurgerParameterizedTests {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final float price;
    Burger burger = new Burger();

    public BurgerParameterizedTests(Bun bun, List<Ingredient> ingredients, float price) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setBurgerParams() {
        return new Object[][]{
                {
                        new Bun("Хтоническая булка", 999.7F),
                        new ArrayList<>(Arrays.asList(
                                new Ingredient(IngredientType.FILLING, "Щупальце Ктулху", 2000),
                                new Ingredient(IngredientType.SAUCE, "Слёзы Йог-Сотота", 1000)
                        )),
                        4999.4F
                },
                {
                        new Bun("Инсмутская булка", 600),
                        new ArrayList<>(Arrays.asList(
                                new Ingredient(IngredientType.FILLING, "Филе подводного отродья", 1200),
                                new Ingredient(IngredientType.FILLING, "Сыр из молока морских коров", 700),
                                new Ingredient(IngredientType.FILLING, "Морской салат", 300),
                                new Ingredient(IngredientType.SAUCE, "Слизь Дагона", 1500)
                        )),
                        4900
                },
                {
                        new Bun("Закатная булка", 900),
                        new ArrayList<>(Arrays.asList(
                                new Ingredient(IngredientType.FILLING, "Лапки лунных жаб", 1350.25F),
                                new Ingredient(IngredientType.FILLING, "Львиная котлета", 900),
                                new Ingredient(IngredientType.SAUCE, "Лунная пыль", 1900)
                        )),
                        5950.25F
                },
        };
    }

    //Проверим добавление булки
    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertSame(burger.bun, bun);
    }

    //Проверим, что метод getPrice возвращает верную стоимость бургера
    @Test
    public void testBurgerPrice() {
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        assertEquals("Цена не верна!", price, burger.getPrice(), 0.05);
    }

    //Проверим, что метод getReceipt возвращает корректный чек
    @Test
    public void testReceipt() {
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", price));
        assertEquals("Рецепт не верный!", receipt.toString(), burger.getReceipt());
    }


}


